package com.stoletnaedine;

import com.stoletnaedine.controller.StorageController;
import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.OccupiedException;
import com.stoletnaedine.view.ConsoleView;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean quit = false;

        final ConsoleView cv = new ConsoleView();
        final StorageController sc = new StorageController();

        String nameOfWarehouse = cv.askInput("name of warehouse");

        System.out.println("Ok, please input size of warehouse:");
        int Y = cv.askCoordinate("X");
        int X = cv.askCoordinate("Y");
        Storage storage = new Storage(X, Y);

        Session session = new Session(storage, nameOfWarehouse);

        while (!quit) {
            String command = cv.askInput("command or help");
            switch (command) {
                case "help":
                    cv.help();
                    break;

                case "show":
                    cv.show(session);
                    break;

                case "set":
                    System.out.println("Please input article:");
                    int id = cv.askIdArticle("Id");
                    String title = cv.askTitleArticle("Title");
                    Article article = new Article(id, title);

                    System.out.println("Where to put?");

                    final Point point = cv.askPoint();
                    try {
                        sc.setArticle(storage, point, article);
                    } catch (final InvalidPointException | OccupiedException e){}
                    break;

                case "quit":
                    quit = true;
                    break;

                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
}
