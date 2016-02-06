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
public class boundedRectangle extends boundedLine{
    
    public boundedRectangle(BufferedImage c) {
        super(c);
    }
    
    @Override
    public void draw(int x0,int y0,int x1,int y1){
        
        int x = (x1 - x0) / 2;
        int y = (y1 - y0) / 2;
        this.setCenter(x0 + x, y0 + y); 
        
        super.draw(x0,y0,x0,y1);
        super.draw(x0,y0,x1,y0);
        super.draw(x0,y1,x1,y1);
        super.draw(x1,y0,x1,y1);
    
    }
    
}
