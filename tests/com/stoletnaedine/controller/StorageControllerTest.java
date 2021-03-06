package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StorageControllerTest {

    @Test
    public void testGetRandomInt() {
        int a = StorageController.getRandomInt(1,1000);
        assert (a > 0 && a < 1000);
    }

    @Test
    public void testGetArticleBySearch() {
        Storage storage = new Storage(4,5);
        storage.setArticle(new Point(2,4), new Article(6391, "Fireball"));
        storage.setArticle(new Point(4,1), new Article(1234, "fIREball"));
        ArrayList<String> expected = new ArrayList<>();
        expected.add("2-4 | 6391 | Fireball");
        expected.add("4-1 | 1234 | fIREball");
        assert expected.equals(StorageController.getArticleBySearch(storage, "fire"));
    }

    @Test
    public void testRandomFillCells() throws OccupiedException, NoPlaceException, InvalidPointException {
        Storage storage = new Storage(5,5);
        StorageController.randomFillCells(storage, 25);
        assert 25 == StorageController.counterOccupiedCells(storage);
    }

    @Test
    public void testGetListAllArticles() {
        Storage storage = new Storage(4,5);
        storage.setArticle(new Point(1,3), new Article(6391, "Fireball"));
        storage.setArticle(new Point(2,1), new Article(1234, "Football"));
        storage.setArticle(new Point(4,3), new Article(1111, "HowHow"));

        String[] expected = new String[3];
        expected[0] = "1-3 | 6391 | Fireball";
        expected[1] = "2-1 | 1234 | Football";
        expected[2] = "4-3 | 1111 | HowHow";
        String[] current = StorageController.getListAllArticles(storage);
        assert Arrays.equals(current, expected);
    }

    @Test
    public void setArticle() {
        Storage storage = new Storage(4,5);
        Point point = new Point(1,3);
        Article current = new Article(6391, "Fireball");
        storage.setArticle(point, current);
        Article expected = storage.getArticle(new Point(1, 3));
        assert current == expected;
    }
}