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
public class BoundedCircle extends BrensenhamCircle{
    
    public BoundedCircle(BufferedImage c) {
        super(c);
    }
    
    public void putPixel(int x,int y){
        if((this.bx0!=-1 && this.bx0<x && this.bx1>x && this.by0<y && this.by1 > y))
            super.putPixel(x, y);
    }
    
}
