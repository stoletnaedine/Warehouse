package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;

import java.awt.*;

public class StorageController {

    private static boolean checkCoorinate(final Storage storage, final Point point){
        return point.x > 0 && point.x <= storage.getX()
                && point.y > 0 && point.y <= storage.getY();
    }

    public static boolean checkNoPlaceStorage(final Storage storage) {
        return counterOccupiedCells(storage) == storage.getSize();
    }

    public static void randomFillCells(final Storage storage, int n) throws OccupiedException, InvalidPointException {
        if (n > storage.getSize())
            n = storage.getSize();
        do {
            setArticle(storage, getNullPoint(storage), new Article());
        } while (counterOccupiedCells(storage) < n);
    }

    private static Point getNullPoint(final Storage storage){
        Point result = getRandomPoint(storage);
        while (storage.getArticle(result) != null) {
            result = getRandomPoint(storage);
        }
        return result;
    }

    private static Point getRandomPoint(final Storage storage){
        return new Point(getRandomInt(storage.getX()), getRandomInt(storage.getY()));
    }

    private static int getRandomInt(final int endCoordinate){
        return 1 + (int) (Math.random() * endCoordinate);
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
            throws InvalidPointException, OccupiedException {
        if (!checkCoorinate(storage, point)) {
            throw new InvalidPointException();
        }
        if (storage.getArticle(point) != null) {
            throw new OccupiedException();
        }
        storage.setArticle(point, article);
    }

    public static Article getArticle(final Storage storage, final Point point)
            throws InvalidPointException, OccupiedException {
        if (!checkCoorinate(storage, point)) {
            throw new InvalidPointException();
        }
        if (storage.getArticle(point) != null) {
            throw new OccupiedException();
        }
        return storage.getArticle(point);
    }

}
