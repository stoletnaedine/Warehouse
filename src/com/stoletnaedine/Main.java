package com.stoletnaedine;

import com.stoletnaedine.controller.StorageController;
import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;
import com.stoletnaedine.model.exceptions.NoPlaceException;
import com.stoletnaedine.model.exceptions.NullSizeStorageException;
import com.stoletnaedine.model.exceptions.OccupiedException;
import com.stoletnaedine.view.ConsoleView;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws OccupiedException, InvalidPointException, NoPlaceException {

        boolean quit = false;

        final ConsoleView cv = new ConsoleView();

        String nameOfWarehouse = cv.askString("name of warehouse").trim();

        int X = 0;
        int Y = 0;

        boolean validCoordinate = false;

        while (!validCoordinate) {
            System.out.println("Ok, please input size of warehouse:");
            try {
                Y = cv.askInt("X");
                X = cv.askInt("Y");
                validCoordinate = StorageController.checkNotNullSizeStorage(X, Y);
            } catch (final NullSizeStorageException e) {
                System.out.println("- - - Please, input again - - -");
            }
        }

        Storage storage = new Storage(X, Y);

        Session session = new Session(storage, nameOfWarehouse);

        while (!quit) {

            String command = cv.askString("command or (h)elp").trim();
            switch (command) {
                case "h":
                case "help":
                    cv.help();
                    break;

                case "s":
                case "set":
                    System.out.println("Please input article:");
                    int id = cv.askInt("Id?");
                    String title = cv.askString("Title?");
                    Article article = new Article(id, title);

                    System.out.println("Where to put?");
                    final Point point = cv.askPoint();
                    try {
                        StorageController.setArticle(storage, point, article);
                    } catch (final InvalidPointException | OccupiedException e){
                        System.out.println("- - - Please, input again - - -");
                    }
                    break;

                case "p":
                case "print":
                    cv.show(session);
                    break;

                case "r":
                case "random":
                    int n = cv.askInt("number of cells");
                    StorageController.randomFillCells(storage, n);
                    break;

                case "l":
                case "list":
                    cv.printListAllArticles(storage);
                    break;

                case "f":
                case "find":
                    String searchString = cv.askString("cell ('X-Y'), id or title");
                    cv.searchArticleById(storage, searchString);
                    break;

                case "q":
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
