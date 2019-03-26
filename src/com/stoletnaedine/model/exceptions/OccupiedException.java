package com.stoletnaedine.model.exceptions;

public class OccupiedException extends AbstractException {

    public OccupiedException() {
        System.out.println("ERROR: This cell is occupied!");
    }
}
