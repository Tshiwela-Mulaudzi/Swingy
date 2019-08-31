package com.swingy;

import com.swingy.controller.GamePlay;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            String report = String.format("ERROR: Please pass at least one argument.\n");
            System.out.println(report);
            System.exit(1);
        } else {
            GamePlay gamePlay = new GamePlay(args[0]);
        }
    }
}