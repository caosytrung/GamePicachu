package com.caotrung.picachu;

import java.awt.*;

/**
 * Created by caotr on 03/06/2016.
 */
public class Pokemon {
    public static final int SIZE_POKEMON = 40;
    private Image image;
    private int idPokemon;

    public Pokemon(Image image, int idPokemon) {
        this.image = image;
        this.idPokemon = idPokemon;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }
    public void showPokemon(Graphics2D g2d,int x,int y){
        g2d.drawImage(image,x,y,SIZE_POKEMON,SIZE_POKEMON,null);
    }
}
