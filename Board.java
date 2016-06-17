package com.caotrung.picachu;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Random;

/**
 * Created by caotr on 03/06/2016.
 */
public class Board {
    public static final int COL = 14;
    public static final int ROW = 10;
    public boolean[][] manager;
    public boolean[][] catchClick;

    public Board() {

        manager = new boolean[10][14];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                manager[i][j] = false;
            }
        }
        catchClick = new boolean[10][14];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {
                catchClick[i][j] = false;
            }
        }
    }

    private Pokemon[][] listPokemon;
    public static Image[] imagePokemons = {
            new ImageIcon(Board.class.
                    getResource("/image/chim.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/la.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/me.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/mu.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/ngua.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/tho.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/xuong.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/saobien.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/khunglong.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/meo.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/chuot.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/ech.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/haicau.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/lon.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/sanho.jpg")).getImage(),
            new ImageIcon(Board.class.
                    getResource("/image/cu.jpg")).getImage()

    };

    public void initPokemon() {
        listPokemon = new Pokemon[10][14];

        for (int pos = 0; pos < imagePokemons.length; pos++) {
            for (int i = 0; i < 6; i++) {
                Random random = new Random();
                while (true) {
                    int x = 1 + random.nextInt(8);
                    int y = 1 + random.nextInt(12);
                    if (!manager[x][y]) {
                        listPokemon[x][y] = new Pokemon(imagePokemons[pos], 1);
                        manager[x][y] = true;
                        break;
                    }
                }
            }
        }
    }

    public boolean[][] getManager() {
        return manager;
    }

    public void setManager(boolean[][] manager) {
        this.manager = manager;
    }

    public void drawALLPokemon(Graphics2D g2d) {
        for (int i = 1; i < ROW; i++) {
            for (int j = 1; j < COL; j++) {
                if (manager[i][j]) {
                    listPokemon[i][j].showPokemon(g2d,
                            j * Pokemon.SIZE_POKEMON,
                            i * Pokemon.SIZE_POKEMON);

                }
            }
        }
    }

    public void checkEat() {
        Point point1 = new Point();
        Point point2 = new Point();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 14; j++) {

                if (catchClick[i][j]) {
                    count++;
                    if (count == 1) {
                        point1 = new Point(i, j);
                    }
                    if (count == 2) {
                        point2 = new Point(i, j);
                    }
                }
            }
        }
        //        System.out.println(count);
        //        System.out.println("---------------------------------------");
        if (count == 2) {
            count = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 14; j++) {
                    catchClick[i][j] = false;
                }
            }

            Pokemon pokemon1 = listPokemon[(int) point1.getX()][(int) point1.getY()];
            Pokemon pokemon2 = listPokemon[(int) point2.getX()][(int) point2.getY()];
            int row1 = (int) point1.getX();
            int col1 = (int) point1.getY();
            int row2 = (int) point2.getX();
            int col2 = (int) point2.getY();
            if (pokemon1.getImage() == pokemon2.getImage()) {

                if (row1 == row2) {
                    if (checkRow(col1, col2, row1)) {
                        manager[(int) point1.getX()][(int) point1.getY()] = false;
                        manager[(int) point2.getX()][(int) point2.getY()] = false;
                        return;
                    }
                } else {
                    if (col1 == col2) {
                        if (checkCol(row1, row2, col1)) {
                            manager[(int) point1.getX()][(int) point1.getY()] = false;
                            manager[(int) point2.getX()][(int) point2.getY()] = false;
                            return;
                        }
                    }
                }

                if (checkRecX(row1, row2, col1, col2) ) {
                    manager[(int) point1.getX()][(int) point1.getY()] = false;
                    manager[(int) point2.getX()][(int) point2.getY()] = false;
                    return;
                }

                if (checkRecY(row1,row2,col1,col2)){
                    manager[(int) point1.getX()][(int) point1.getY()] = false;
                    manager[(int) point2.getX()][(int) point2.getY()] = false;
                    return;
                }
                if (checkMoreRow(row1, row2, col1, col2, 1)) {
                    manager[(int) point1.getX()][(int) point1.getY()] = false;
                    manager[(int) point2.getX()][(int) point2.getY()] = false;
                    return;
                }
                if(checkMoreRow(row1, row2, col1, col2, -1)){
                    manager[(int) point1.getX()][(int) point1.getY()] = false;
                    manager[(int) point2.getX()][(int) point2.getY()] = false;
                    return;
                }
                if(checkMoreCol(row1,row2,col1, col2,1)){
                    manager[(int) point1.getX()][(int) point1.getY()] = false;
                    manager[(int) point2.getX()][(int) point2.getY()] = false;
                    return;
                }
                if (checkMoreCol(row1,row2, col1 , col2, -1)){
                    manager[(int) point1.getX()][(int) point1.getY()] = false;
                    manager[(int) point2.getX()][(int) point2.getY()] = false;
                    return;
                }
            }
        }

    }



    public boolean checkRow(int col1, int col2, int row) {
        int max = Math.max(col1, col2);
        int min = Math.min(col1, col2);
        //        if(max-1 == min){
        //            return true;
        //        }
        for (int i = min + 1; i < max; i++) {
            if (manager[row][i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int row1, int row2, int col) {
        int max = Math.max(row1, row2);
        int min = Math.min(row1, row2);
        //        if(max-1 == min){
        //            return true;
        //        }
        for (int i = min + 1; i < max; i++) {
            if (manager[i][col]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRecX(int row1, int row2, int col1, int col2) {
        int colMax, colMin, rowMax, rowMin;
        if (col2 < col1) {
            colMax = col1;
            colMin = col2;
            rowMax = row1;
            rowMin = row2;
        } else {
            colMax = col2;
            colMin = col1;
            rowMax = row2;
            rowMin = row1;
        }
        for (int i = colMin; i < colMax + 1; i++) {
            if (i > colMin && manager[rowMin][i] == true) {
                return false;
            }
            if ((manager[rowMax][i] == false || i == colMax) &&
                    checkCol(rowMin, rowMax, i) &&
                    checkRow(i, colMax, rowMax)) {
                return true;
            }
            //            System.out.println(checkRow(colMin,i+1,rowMin) +" "+  checkRow(i, colMax+1,rowMax)  +" " + checkCol(rowMin-1,rowMax,i));
            //            if(checkRow(colMin,i+1,rowMin) && checkRow(i, colMax+1,rowMax) && checkCol(rowMin-1,rowMax,i)){
            //                return true;
            //            }
        }
        return false;
    }

    public boolean checkRecY(int row1, int row2, int col1, int col2) {
        int colMax, colMin, rowMax, rowMin;
        if (row1 > row2) {
            colMax = col1;
            colMin = col2;
            rowMax = row1;
            rowMin = row2;
        } else {
            colMax = col2;
            colMin = col1;
            rowMax = row2;
            rowMin = row1;
        }
        for (int i = rowMin; i < rowMax + 1; i++) {
            if (i > rowMin && manager[i][colMin]) {
                return false;
            }
            if ((!manager[i][colMax] || i == rowMax) &&
                    checkCol(i, rowMax, colMax) &&
                    checkRow(colMin, colMax, i)
                    ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMoreRow(int row1, int row2, int col1, int col2, int direction) {
        int colMax, colMin, rowMax, rowMin;
        if (row1 > row2) {
            colMax = col1;
            colMin = col2;
            rowMax = row1;
            rowMin = row2;
        } else {
            colMax = col2;
            colMin = col1;
            rowMax = row2;
            rowMin = row1;
        }

        int moreMax = colMax + direction;
        int colFinal = colMax;
        int row = rowMin;
        if (direction == -1) {
            moreMax = colMin + direction;
            row = rowMax;
            colFinal = colMin;

        }


        if ((!manager[row][colFinal] || colMax == colMin) &&
                checkRow(colMin, colMax, row)
                ) {
            while (!manager[rowMin][moreMax] && !manager[rowMax][moreMax] && moreMax < 15) {
                if (checkCol(rowMin, rowMax, moreMax)) {
                    return true;
                }
            }
            moreMax = moreMax + direction;
        }
        return false;
    }

    public boolean checkMoreCol(int row1, int row2, int col1, int col2, int direction) {
        int colMax;
        int colMin;
        int rowMax;
        int rowMin;


        if (row1 > row2) {
            colMax = col1;
            colMin = col2;
            rowMax = row1;
            rowMin = row2;
        } else {
            colMax = col2;
            colMin = col1;
            rowMax = row2;
            rowMin = row1;
        }
        int moreMax = rowMax + direction;
        int rowFinal = rowMax;
        int col = colMin;
        if ((!manager[rowFinal][col] || rowMin == rowMax) &&
                checkCol(rowMin, rowMax, col)) {
            while (!manager[moreMax][colMin] && !manager[moreMax][colMax] && moreMax < 15) {
                if (checkRow(colMin, colMax, moreMax)) {
                    return true;
                }
            }
        }
        return false;
    }
}

