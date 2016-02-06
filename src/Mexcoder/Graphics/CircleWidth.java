/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public class CircleWidth extends BrensenhamCircle{
    
    public CircleWidth(BufferedImage c) {
        super(c);
    }

    @Override
    public void drawAtCenter(int cx, int cy, int r) {
        
        this.setCenter(cx, cy);
        
        super.drawAtCenter(cx, cy, r+(this.width-1));
        this.floodFill();
        Color tmp = this.c;
        this.c = Color.WHITE;
        super.drawAtCenter(cx, cy, r-1);
        this.floodFill();
        this.c = tmp;
        
        
        /*for (int i = 0; i < this.width; i++) {
                super.drawAtCenter(cx, cy, r+i); //To change body of generated methods, choose Tools | Templates.

        }*/
    }
    
    protected int width = 1;

    public void setWidth(int w) {
        this.width = w;
    }
    
}
