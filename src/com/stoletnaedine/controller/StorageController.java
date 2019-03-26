package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;

import java.awt.*;

public class StorageController {

    public boolean checkCoorinate(final Storage storage, final Point point){
        return point.x >= 0 && point.x <= storage.getX()
                && point.y >= 0 && point.y <= storage.getY();
    }

    public boolean checkNoPlaceStorage(final Storage storage) {
        return sc.counterOccupiedCells(storage) < storage.getSize();
    }

    public void randomFillCells(final Storage storage, final int n) {
        StorageController sc = new StorageController();
        Article article = new Article();
        do {
            sc.setArticle(storage, new Point(Math.random() * 10, Math.random() * 10), article);
        } while (sc.counterOccupiedCells(storage) < n)
    }

    private int counterOccupiedCells(Storage storage) {
        int counter = 0;

        for (int i = 1; i <= storage.getX(); i++)
            for (int i2 = 1; i2 <= storage.getY(); i2++)
                if (new Point(i, i2) != null) {
                    counter += 1;
                }
        return counter;
    }

    public void setArticle(final Storage storage, final Point point, final Article article)
            throws InvalidPointException, OccupiedException{
        if (!checkCoorinate(storage, point)) {
            throw new InvalidPointException();
        }
        if (storage.getArticle(point) != null) {
            throw new OccupiedException();
        }
        storage.setArticle(point, article);
    }

}
