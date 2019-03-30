package com.stoletnaedine.controller;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Storage;
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
    public void testGetArticleBySearch() throws Exception {
        Storage storage = new Storage(4,5);
        storage.setArticle(new Point(2,4), new Article(6391, "Fireball"));
        storage.setArticle(new Point(4,1), new Article(1234, "fIREball"));
        ArrayList<String> expected = new ArrayList<>();
        expected.add("2-4 | 6391 | Fireball");
        expected.add("4-1 | 1234 | fIREball");
        assert expected.equals(StorageController.getArticleBySearch(storage, "fire"));
    }

    @Test
    public void randomFillCells() {
    }

    @Test
    public void getListAllArticles() {
    }

    @Test
    public void setArticle() {
    }
}