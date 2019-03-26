package com.stoletnaedine.view;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

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
	}

	private void printLine(final Storage storage,
						   final int x) {
		for (int y = 0; y < storage.getY(); y++) {
			System.out.print("|");
			System.out.print(" ");

			System.out.print(storage.getArticle(new Point(x, y)) != null ? "X" : ".");
			System.out.print(" ");
		}
        System.out.print("|");
		System.out.println();
	}

	private void printSeparator() {
		System.out.print("-");
	}

}
