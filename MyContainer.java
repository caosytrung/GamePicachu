package com.caotrung.picachu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by caotr on 02/06/2016.
 */
public class MyContainer extends BaseContainer {
    public static final int WIDTH_MYCONTAINER = 900;
    public static final int HEIGHT_MYCONTAINER = 700;

    @Override
    public void initContainer() {
        setSize(WIDTH_MYCONTAINER,HEIGHT_MYCONTAINER);
        setBackground(Color.BLACK);
        setLayout(null);
    }

    @Override
    public void initComponent() {
        PanelDisplayGame panelDisplayGame= new PanelDisplayGame();
        add(panelDisplayGame);
        add(new PanelGameControl());

    }

    @Override
    public void initCommons() {

    }
}
