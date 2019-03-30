package com.stoletnaedine.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    @Test
    void getId() {
        int expected = 213;
        Article article = new Article(expected, null);
        int current = article.getId();
        assertEquals(current, expected);
    }

    @Test
    void getTitle() {
        String expected = "test";
        Article article = new Article(1234, expected);
        String current = article.getTitle();
        assertEquals(current, expected);
    }

    @Test
    void setId() {
        int expected = 145;
        Article article = new Article();
        article.setId(expected);
        int current = article.getId();
        assertEquals(current, expected);
    }

    @Test
    void setTitle() {
        String expected = "test1";
        Article article = new Article();
        article.setTitle(expected);
        String current = article.getTitle();
        assertEquals(current, expected);
    }
}