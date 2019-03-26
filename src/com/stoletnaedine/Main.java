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

        boolean quit = false;



            final ConsoleView cv = new ConsoleView();

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
