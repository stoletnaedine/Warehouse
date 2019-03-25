package com.stoletnaedine;

import com.stoletnaedine.model.Session;
import com.stoletnaedine.model.Storage;
import com.stoletnaedine.view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        final Session session = new Session(new Storage(4,6), "My Backyard");

        final ConsoleView cv = new ConsoleView();
        cv.show(session);

    }
}
