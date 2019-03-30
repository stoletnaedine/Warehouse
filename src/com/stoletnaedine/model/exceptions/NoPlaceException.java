package com.stoletnaedine.model.exceptions;

public class NoPlaceException extends AbstractException {

    public NoPlaceException(){
        System.out.println("ERROR: All cells are occupied!");
    }
}
