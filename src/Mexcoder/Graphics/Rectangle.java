/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Component;

/**
 *
 * @author JuanAntonio
 */
public class Rectangle extends DDALine{
    
    public Rectangle(Component c) {
        super(c);
    }
    
    public void draw(int x0,int y0,int x1,int y1){
        
        super.draw(x0,y0,x0,y1);
        super.draw(x0,y0,x1,y0);
        super.draw(x0,y1,x1,y1);
        super.draw(x1,y0,x1,y1);
    
    }
    
}
