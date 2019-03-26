package com.stoletnaedine.model.exceptions;

public class InvalidPointException extends AbstractException {

    public InvalidPointException(){
        System.out.println("Invalid coordinates!");
    }

    public InvalidPointException(String msg) {
        System.out.println(msg);
    }

}
