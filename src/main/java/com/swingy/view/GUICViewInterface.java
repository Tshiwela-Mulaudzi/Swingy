package com.swingy.view;
import com.swingy.model.Hero;
import javax.swing.JFrame;

public class GUICViewInterface implements ViewModeInterface {
    private final String name = "GUI";
    public static Hero hero = new Hero();

    private static JFrame introWindow;
    private static JFrame createHeroWindow;
    private static JFrame selectHeroWindow;
    private static JFrame gameWindow;

    public GUICViewInterface(){}

    public void init(){
        // Window
        GUICViewInterface.introWindow = new JFrame(this.name + " MODE");
        GUICViewInterface.introWindow.setSize(500, 120);
        GUICViewInterface.introWindow.setLocationRelativeTo(null);
        GUICViewInterface.introWindow.setVisible(true);
    }
    public void run(){
        this.init();
    }
}