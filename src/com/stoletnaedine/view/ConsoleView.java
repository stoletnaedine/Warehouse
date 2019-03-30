package com.stoletnaedine.view;

import com.stoletnaedine.controller.StorageController;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;

import java.awt.*;
import java.util.ArrayList;
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

    public int askInt(final String inputNum) {
        System.out.format("Input %s: ", inputNum);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Wrong input!");
            return askInt(inputNum);
        }
    }

    public String askString(final String inputName) {
        System.out.format("Please input %s: ", inputName);
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
		System.out.println("(h)elp — all comands");
        System.out.println("(s)et - put the item in the cell");
		System.out.println("(p)rint - render warehouse");
		System.out.println("(r)andom - fill cells with random");
        System.out.println("(l)ist — show all articles");
        System.out.println("(f)ind — show article by id");
		System.out.println("(q)uit — close the app");
		System.out.println("~ ~ ~");
	}

	public void again(){
        System.out.println("- - - Please, input again - - -");
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
        if (list.length != 0) {
            System.out.println("cell | id | title");
            for (String article : list
            ) {
                System.out.println(article);
            }
        }
        else
            System.out.println("Sorry, the list is empty.");
    }

    public void searchArticleById(final Storage storage, final String searchString){
        ArrayList list = StorageController.getArticleBySearch(storage, searchString);
        if (!list.isEmpty()) {
            System.out.println("cell | id | title");
            for (Object entry : list
            ) {
                System.out.println(entry.toString());
            }
        }
        else
            System.out.println("Sorry, entry is not found.");
    }
}
