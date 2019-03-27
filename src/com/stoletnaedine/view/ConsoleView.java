package com.stoletnaedine.view;

import com.stoletnaedine.controller.StorageController;
import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private void printLine(final Storage storage,
                           final int x) {
        for (int y = 1; y <= storage.getY(); y++) {
            System.out.print("|");
            System.out.print(" ");

            System.out.print(storage.getArticle(new Point(x, y)) != null ? "X" : " ");
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
    }

    private void printSeparator() {
        System.out.print("-");
    }

	public Point askPoint() {
		return new Point(askInt("vertical"), askInt("horizont"));
	}

    public int askInt(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Wrong input!");
            return askInt(coordinateName);
        }
    }

    public String askString(final String inputName) {
        System.out.format("Please input %s:", inputName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextLine();
        } catch (final InputMismatchException e) {
            System.out.println("Wrong input!");
            return askString(inputName);
        }
    }

	public void help(){
		System.out.println("~ ~ ~");
		System.out.println("help — all comands");
        System.out.println("set - put the item in the box");
		System.out.println("show - render warehouse");
		System.out.println("random - fill N cells");
		System.out.println("quit — close the app");
		System.out.println("~ ~ ~");
	}

	public void show(final Session session) {

        final Storage storage = session.getStorage();
        System.out.println();
		System.out.format("Warehouse name: %s\n", session.getName());

		for (int x = 1; x <= storage.getX(); x++) {

			for (int i = 1; i <= storage.getY() * 4 + 1; i++)
			    printSeparator();
            System.out.println();

			printLine(storage, x);
		}

        for (int i = 0; i < storage.getY() * 4 + 1; i++)
            printSeparator();
        System.out.println();
	}
	
	public void printListAllArticles(final Storage storage) {
        String[] list = StorageController.getListAllArticles(storage);
        for (String article : list
             ) {
            System.out.println(article);
        }
    }

}
