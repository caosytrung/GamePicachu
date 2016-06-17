package com.caotrung.picachu;

import javax.swing.*;

/**
 * Created by caotr on 02/06/2016.
 */
public class GUI extends JFrame {
    public static final int WIDTH_FRAME = 750;
    public static final int HEIGHT_FRAME = 600;

    public GUI(){
        initGUI();
        initComponent();

    }
    public void initGUI(){
        setTitle("Pi cà chú  ");
        setSize(WIDTH_FRAME,HEIGHT_FRAME);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void initComponent(){
        add(new MyContainer());
    }

}
