package com.swingy.helpers;

public class NoDataException extends Exception {
    public void message(){
        System.out.println("\nERROR\nNo previous data saved.");

    }
}