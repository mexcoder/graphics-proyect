/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public class boundedLine extends BrensenhamLine {
    
    public boundedLine(BufferedImage c) {
        super(c);
    }
    
    /**
     *
     * @param x0
     * @param y0
     * @param xi
     * @param y1
     */
    public void boundToRect(int x0,int y0,int x1,int y1){
        super.bountToRect(x0, y0, x1, y1);
    }
    
    public void putPixel(int x,int y){
        if((this.bx0!=-1 && this.bx0<x && this.bx1>x && this.by0<y && this.by1 > y))
            super.putPixel(x, y);
    }
    
}
