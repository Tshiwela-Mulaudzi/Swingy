package com.swingy.controller;
import com.swingy.view.ViewModeInterface;
import com.swingy.view.GUICViewInterface;
import com.swingy.view.ConsoleViewInterface;
import com.swingy.helpers.Tools;

public class GamePlay {
    private String ModeOfGame = null;
    private ViewModeInterface view = null;

    public GamePlay(String ModeOfGame){
        if (ModeOfGame.equals("console")){
            this.ModeOfGame = "CONSOLE";
            System.out.println("GAME");
            this.view = new ConsoleViewInterface();
            this.view.run();
        }
        else if (ModeOfGame.equals("gui")) {
            this.ModeOfGame = "GUI";
            System.out.println("GAME");
            this.view = new GUICViewInterface();
            this.view.run();
        }
        else{
            String report = String.format("\nWrong mode.\n");
            System.out.println(report);
            System.exit(1);
        }
    }

    public void run(){
    }
}