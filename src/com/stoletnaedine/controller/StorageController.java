package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;

import java.awt.*;

public class StorageController {

    public void checkNoPlaceStorage(Storage storage) throws NoPlaceException {

        int counter = 0;

        for (int i = 0; i < storage.getX(); i++)
            for (int i2 = 0; i2 < storage.getY(); i2++)
                if (new Point(i, i2) != null) {
                    counter += 1;
                }

        if (counter == storage.getSize()) throw new NoPlaceException();

    }

    private boolean checkCoorinate(Storage storage, Point point){
        return point.x >= 0 && point.x <= storage.getX()
                && point.y >= 0 && point.y <= storage.getY();
    }

    public void setArticle(Storage storage, Point point, Article article)
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
