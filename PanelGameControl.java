package com.caotrung.picachu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by caotr on 02/06/2016.
 */
public class PanelGameControl extends BaseContainer implements  Runnable {
    public static final int WIDTH_CONTROL = 480;
    public static final int HEIGHT_CONTROL = 40;
    private MouseAdapter mouseAdapter;
    public PanelGameControl(){
        super();

    }

    @Override
    public void initContainer() {
        setSize(WIDTH_CONTROL,HEIGHT_CONTROL);
        setLocation((GUI.WIDTH_FRAME - PanelDisplayGame.WIDTH_DSPLAY)/2,20);
        setBackground(Color.GREEN);
        setLayout(null);
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void initCommons() {
        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {

    }


}
