package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;

import java.awt.*;

public class StorageController {

    private static boolean checkCoordinate(final Storage storage, final Point point){
        return point.x > 0 && point.x <= storage.getX()
                && point.y > 0 && point.y <= storage.getY();
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

    private static int getRandomInt(final int endNum){
        return 1 + (int) (Math.random() * endNum);
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

    public static String[] getListAllArticles(final Storage storage) {
        String[] list = new String[counterOccupiedCells(storage)];
        int position = 0;
        for (int i = 1; i <= storage.getX(); i++)
            for (int i2 = 1; i2 <= storage.getY(); i2++)
                if (storage.getArticle(new Point(i, i2)) != null) {
                    list[position] = storage.getArticle(new Point(i, i2)).getId() + " | " + storage.getArticle(new Point(i, i2)).getTitle();
                    position++;
                }
        return list;
    }

    public static boolean checkNoPlaceStorage(final Storage storage) {
            return counterOccupiedCells(storage) == storage.getSize();
    }

    public static void randomFillCells(final Storage storage, int n) throws OccupiedException, InvalidPointException, NoPlaceException {
        if (n > storage.getSize()) n = storage.getSize();
        do {
            setArticle(storage, getNullPoint(storage), new Article(getRandomInt(1000), "MacBook"));
        } while (counterOccupiedCells(storage) < n);
    }

    public static void setArticle(final Storage storage, final Point point, final Article article)
            throws InvalidPointException, OccupiedException, NoPlaceException {
        if (!checkCoordinate(storage, point)) {
            throw new InvalidPointException();
        }
        if (storage.getArticle(point) != null) {
            throw new OccupiedException();
        }
        if (checkNoPlaceStorage(storage)) {
            throw new NoPlaceException();
        }
        storage.setArticle(point, article);
    }

}
