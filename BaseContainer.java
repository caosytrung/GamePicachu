package com.caotrung.picachu;

import javax.swing.*;

/**
 * Created by caotr on 02/06/2016.
 */
public abstract class BaseContainer
        extends JPanel{
    public BaseContainer(){
        initContainer();
        initComponent();
        initCommons();
    }
    abstract public void initContainer();
    abstract public void initComponent();
    abstract public void initCommons();
}
