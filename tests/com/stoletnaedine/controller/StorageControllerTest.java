package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

public class StorageControllerTest {

    @Test
    public void checkNotNullSizeStorage() {
    }

    @Test
    public void getRandomInt() {
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
    public void getListAllArticles() {
    }

    @Test
    public void setArticle() {
    }
}