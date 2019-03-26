package com.stoletnaedine.view;

import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

	public String askInput(final String inputName) {
		System.out.format("Please input %s:", inputName);
		final Scanner in = new Scanner(System.in);
		try {
			return in.nextLine();
		} catch (final InputMismatchException e) {
			System.out.println("Wrong input!");
			return askInput(inputName);
		}
	}

    public int askCoordinate(final String coordinateName) {
		System.out.format("Please input %s:", coordinateName);
		final Scanner in = new Scanner(System.in);
		try {
			return in.nextInt();
		} catch (final InputMismatchException e) {
			System.out.println("Wrong input!");
			return askCoordinate(coordinateName);
		}
	}

    public int askIdArticle(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Wrong input!");
            return askCoordinate(coordinateName);
        }
    }

    public String askTitleArticle(final String inputName) {
        System.out.format("Please input %s:", inputName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextLine();
        } catch (final InputMismatchException e) {
            System.out.println("Wrong input!");
            return askInput(inputName);
        }
    }

	public void help(){
		System.out.println("help — all comands");
        System.out.println("set - put the item in the box");
		System.out.println("show - render warehouse");
		System.out.println("quit — close the app");
	}


	public void show(final Session session) {

		System.out.format("Warehouse name: %s\n", session.getName());
		final Storage storage = session.getStorage();
		for (int x = 0; x < storage.getX(); x++) {

			for (int i = 0; i < storage.getY() * 4 + 1; i++)
			    printSeparator();

            System.out.println();
			printLine(storage, x);
		}

        for (int i = 0; i < storage.getY() * 4 + 1; i++)
            printSeparator();
        System.out.println();
	}

	private void printLine(final Storage storage,
						   final int x) {
		for (int y = 0; y < storage.getY(); y++) {
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

}
