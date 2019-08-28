package com.swingy.controller;
import com.swingy.view.ViewModeInterface;
import com.swingy.view.GUICViewInterface;
import com.swingy.view.ConsoleViewInterface;
import com.swingy.helpers.Tools;

public class GamePlay {
    private final String FILENAME = "heroes.txt";
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
            String report = String.format("\nERROR\nWrong mode.\nUSAGE:\n%sjava -jar swing.jar console\n %sOR\n%sjava -jar swing.jar gui", Tools.padLeft(" ", 7), Tools.padLeft(" ", 19), Tools.padLeft(" ", 7));
            System.out.println(report);
            System.exit(1);
        }
    }

    public void run(){

    }
}