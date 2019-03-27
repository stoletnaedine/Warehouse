package com.stoletnaedine;

import com.stoletnaedine.controller.StorageController;
import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.OccupiedException;
import com.stoletnaedine.view.ConsoleView;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws OccupiedException, InvalidPointException, NoPlaceException {

        boolean quit = false;

        final ConsoleView cv = new ConsoleView();

        String nameOfWarehouse = cv.askString("name of warehouse");

        System.out.println("Ok, please input size of warehouse:");
        int Y = cv.askInt("X");
        int X = cv.askInt("Y");
        Storage storage = new Storage(X, Y);

        Session session = new Session(storage, nameOfWarehouse);

        while (!quit) {
            String command = cv.askString("command or help");
            switch (command) {
                case "help":
                    cv.help();
                    break;

                case "show":
                    cv.show(session);
                    break;

                case "random":
                    int n = cv.askInt("Number of cells?");
                    StorageController.randomFillCells(storage, n);
                    break;

                case "set":
                    System.out.println("Please input article:");
                    int id = cv.askInt("Id?");
                    String title = cv.askString("Title?");
                    Article article = new Article(id, title);

                    System.out.println("Where to put?");
                    final Point point = cv.askPoint();
                    try {
                        StorageController.setArticle(storage, point, article);
                    } catch (final InvalidPointException | OccupiedException e){}
                    break;

                case "list":
                    cv.printListAllArticles(storage);
                    break;

                case "quit":
                    quit = true;
                    break;

                default:
                    System.out.println("ERROR: incorrect command!");
                    break;
            }
        }
    }
}
