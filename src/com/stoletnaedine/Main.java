package com.stoletnaedine;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.view.ConsoleView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage(3,6);

        Article a1 = new Article(12, "iPhone");

        Article a2 = new Article(15, "iPad");

        storage.setArticle (new Point(1,4), a1);

        final Session session = new Session(storage, "My Backyard");

        final ConsoleView cv = new ConsoleView();
        cv.show(session);

    }
}
