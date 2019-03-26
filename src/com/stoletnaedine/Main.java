package com.stoletnaedine;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.view.ConsoleView;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final ConsoleView cv = new ConsoleView();

        boolean quit = false;

        while (!quit) {
            String command = cv.askInput("Command or help");

            switch (command) {
                case "help":
                    cv.help();
                    break;

                case "size":
                    int Y = cv.askCoordinate("X");
                    int X = cv.askCoordinate("Y");
                    Storage storage = new Storage(X, Y);
                    break;

                case "quit":
                    quit = true;
                    break;

                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }

//        Article a1 = new Article(12, "iPhone");
//        Article a2 = new Article(15, "iPad");

       // storage.setArticle (new Point(2,10), a1);

        //final Session session = new Session(storage, "My MindBox");

        //cv.show(session);

    }
}
