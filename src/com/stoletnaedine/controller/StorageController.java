package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;

import java.awt.*;

public class StorageController {

    public static boolean checkCoorinate(final Storage storage, final Point point){
        return point.x >= 0 && point.x <= storage.getX()
                && point.y >= 0 && point.y <= storage.getY();
    }

    public static boolean checkNoPlaceStorage(final Storage storage) {
        return counterOccupiedCells(storage) == storage.getSize();
    }

    public static void randomFillCells(final Storage storage, final int n) throws OccupiedException, InvalidPointException {
        int begin = 1;
        int endX = storage.getX();
        int endY = storage.getY();
        do {
            setArticle(storage, new Point(begin + (int) (Math.random() * endX), begin + (int) (Math.random() * endY)), new Article());
        } while (counterOccupiedCells(storage) < n);
    }

    private static int counterOccupiedCells(final Storage storage) {
        int counter = 0;

        for (int i = 1; i <= storage.getX(); i++)
            for (int i2 = 1; i2 <= storage.getY(); i2++)
                if (storage.getArticle(new Point(i, i2)) != null) {
                    counter += 1;
                }
        return counter;
    }

    public static void setArticle(final Storage storage, final Point point, final Article article)
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
