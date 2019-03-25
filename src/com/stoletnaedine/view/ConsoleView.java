package com.stoletnaedine.view;

import com.stoletnaedine.model.Article;
import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.model.exceptions.InvalidPointException;

import java.awt.*;

public class ConsoleView {

//	private int askCoordinate(final String coordinateName) {
//		System.out.format("Please input %s:", coordinateName);
//		final Scanner in = new Scanner(System.in);
//		try {
//			return in.nextInt();
//		} catch (final InputMismatchException e) {
//			System.out.println("0_0 olololo!!!!!");
//			return askCoordinate(coordinateName);
//		}
//	}

	public void show(Session session) {

		System.out.format("Warehouse name: %s\n", session.getName());
		final Storage storage = session.getStorage();
		for (int x = 0; x < storage.getX(); x++) {
			//if (x != 0)

				printSeparator();
			printLine(storage, x);
		}

	}

	private void printLine(final Storage storage,
						   final int x) {
		for (int y = 0; y < storage.getY(); y++) {
			if (y != 0)
				System.out.print("|");
			System.out.print(" ");


			System.out.print(storage.getArticle(new Point(x, y)) != null ? " X " : " . ");
			System.out.print(" ");
		}
		System.out.println();
	}

	private void printSeparator() {
		System.out.println("--------------------");
	}

}
