package com.caotrung.picachu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by caotr on 02/06/2016.
 */
public class PanelDisplayGame extends BaseContainer implements Runnable{
    public static final int WIDTH_DSPLAY = 560;
    public static final int HEIGHT_DISPLAY = 400;
    private Board board;
    private MouseAdapter mouseAdapter;

    public PanelDisplayGame(){
        super();
    }


    @Override
    public void initContainer() {
        setLocation((GUI.WIDTH_FRAME - PanelDisplayGame.WIDTH_DSPLAY)/2,
                PanelGameControl.HEIGHT_CONTROL + 40);
        setSize(WIDTH_DSPLAY,HEIGHT_DISPLAY);
        setLayout(null);
        setBackground(Color.BLACK);
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void initCommons() {
        board = new Board();
        board.initPokemon();
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Image imgbg = (new ImageIcon(getClass().getResource("/image/bg.jpg"))).getImage();
        g2d.drawImage(imgbg,40,40,12 *40,8 * 40,null);
        board.drawALLPokemon(g2d);
        for (int i = 0 ; i <= Board.COL; i ++){
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(i * Pokemon.SIZE_POKEMON,0,i * Pokemon.SIZE_POKEMON,HEIGHT_DISPLAY);

        }
        for (int i = 0 ; i < Board.ROW; i ++){
            g2d.drawLine(0,i * Pokemon.SIZE_POKEMON,WIDTH_DSPLAY,i * Pokemon.SIZE_POKEMON);
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                catchEventClick();
                board.checkEat();
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PanelDisplayGame.this.repaint();
        }
    }
    public void catchEventClick(){
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int rowClick = e.getY() / 40;
                int colClick = e.getX() / 40;
                board.catchClick[rowClick][colClick] = true;
            }
        };
        addMouseListener(mouseAdapter);
        setFocusable(true);
    }
}
