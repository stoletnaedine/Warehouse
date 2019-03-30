package com.stoletnaedine;

import com.stoletnaedine.controller.StorageController;
import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.*;
import com.stoletnaedine.view.ConsoleView;

import java.awt.*;

import static com.stoletnaedine.controller.StorageController.*;
import static com.stoletnaedine.controller.StorageController.checkNullSizeStorage;

public class Main {

    public static void main(String[] args) throws OccupiedException, InvalidPointException, NoPlaceException, NullSizeStorageException {

        boolean quit = false;

        final ConsoleView cv = new ConsoleView();

        String nameOfWarehouse = cv.askString("name of warehouse").trim();

        int X = 0;
        int Y = 0;

        while (!(X > 0 && Y > 0)) {
            System.out.println("Ok, please input size of warehouse:");
            try {
                X = cv.askInt("X");
                Y = cv.askInt("Y");
                checkNullSizeStorage(X, Y);
               } catch (final NullSizeStorageException e) {
                   cv.again();
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
                    int id = getRandomInt(1, 10000);
                    String title = cv.askString("name of product");
                    Article article = new Article(id, title);

                    System.out.println("Where to put?");
                    final Point point = cv.askPoint();
                    try {
                        setArticle(storage, point, article);
                    } catch (final InvalidPointException | OccupiedException e){
                        cv.again();
                    }
                    break;

                case "p":
                case "print":
                    cv.show(session);
                    break;

                case "r":
                case "random":
                    int n = cv.askInt("number of cells");
                    randomFillCells(storage, n);
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
            }
        }
    }
}
