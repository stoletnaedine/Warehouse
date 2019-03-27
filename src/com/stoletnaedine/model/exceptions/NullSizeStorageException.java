package com.stoletnaedine.model.exceptions;

public class NullSizeStorageException extends Exception {

    public void NullSizeStorageException(){
        System.out.println("ERROR: Coordinate X and Y must be > 0!");
    }
}
