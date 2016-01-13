/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public class Elipse extends SimpleCircle{

    public Elipse(BufferedImage c) {
        super(c);
    }
    
    /*public void draw(int x0, int y0, int x1, int y1, Color c) {
        Color tmp = this.c;
        this.setColor(c);
        this.draw(x0, y0, x1, y1);
        this.setColor(tmp);
    }*/

    @Override
    public void draw(int x0, int y0, int x1, int y1) {
        int x = (x1 - x0) / 2;
        int y = (y1 - y0) / 2;
        this.setCenter(x0 + x, y0 + y); 
        this.drawAtCenter(x0 + x, y0 + y, Math.abs(x),Math.abs(y));
        // x holds the radius (assuming x = y)
        // x0 + x is the center for x 
        // y0 + y is the center for y
    }

    private void drawAtCenter(int cx, int cy, int rx, int ry) {
        int x = rx;
        int y = 0;
        float i = 0;
        int decisionOver2 = 1 - x;   // Decision criterion divided by 2 evaluated at x=r, y=0

        while (x>=0) {
            i+=0.001;
            x = (int) (Math.cos(i) * rx);
            y = (int) (Math.sin(i) * ry);
            this.putPixel(cx + x, cy + y);
            this.putPixel(cx + x, cy - y);
            this.putPixel(cx - x, cy + y);
            this.putPixel(cx - x, cy - y);
            /*this.putPixel(y + cx, x + cy); // Octant 2
            this.putPixel(-x + cx, y + cy); // Octant 4
            this.putPixel(-y + cx, x + cy); // Octant 3
            this.putPixel(-x + cx, -y + cy); // Octant 5
            this.putPixel(-y + cx, -x + cy); // Octant 6
            this.putPixel(x + cx, -y + cy); // Octant 8
            this.putPixel(y + cx, -x + cy); // Octant 7*/
            /*y++;
            if (decisionOver2 <= 0) {
                decisionOver2 += 2 * y + 1;   // Change in decision criterion for y -> y+1
            } else {
                x--;
                decisionOver2 += 2 * (y - x) + 1;   // Change for y -> y+1, x -> x-1
            }*/
        }
    }
    
    
    
}
