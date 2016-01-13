/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public class Pixel extends AbstractPixel{
    
    public Pixel(Component c){
        super(c);
    }

    public void draw(int x, int y) {
        this.putPixel(x, y);
    }

    public void draw(int x, int y, Color c) {
        this.setColor(c);
        this.putPixel(x, y);
    }

}
