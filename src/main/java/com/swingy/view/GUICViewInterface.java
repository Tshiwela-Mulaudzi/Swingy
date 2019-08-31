package com.swingy.view;
import com.swingy.model.Hero;
import javax.swing.JFrame;

public class GUICViewInterface implements ViewModeInterface {
    private final String name = "GUI";
    private static JFrame introWindow;

    public GUICViewInterface(){}

    public void init(){
        // Window, for now
        GUICViewInterface.introWindow = new JFrame(this.name + " MODE");
        GUICViewInterface.introWindow.setSize(500, 120);
        GUICViewInterface.introWindow.setLocationRelativeTo(null);
        GUICViewInterface.introWindow.setVisible(true);
    }
    public void run(){
        this.init();
    }
}