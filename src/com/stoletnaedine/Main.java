package com.stoletnaedine;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.view.ConsoleView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        final ConsoleView cv = new ConsoleView();

        int Y = cv.askCoordinate("X");
        int X = cv.askCoordinate("Y");

        Storage storage = new Storage(X, Y);

//        Article a1 = new Article(12, "iPhone");
//        Article a2 = new Article(15, "iPad");

       // storage.setArticle (new Point(2,10), a1);

        final Session session = new Session(storage, "My Backyard");

        cv.show(session);

    }
}
