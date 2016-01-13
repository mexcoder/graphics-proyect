/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Component;
import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public class BrensenhamCircle extends SimpleCircle {

    public BrensenhamCircle(BufferedImage c) {
        super(c);
    }

    @Override
    public void drawAtCenter(int cx, int cy, int r) {
        
        int x = r;
        int y = 0;
        int decisionOver2 = 1 - x;   // Decision criterion divided by 2 evaluated at x=r, y=0

        while (y <= x) {
            this.putPixel(x + cx, y + cy); // Octant 1
            this.putPixel(y + cx, x + cy); // Octant 2
            this.putPixel(-x + cx, y + cy); // Octant 4
            this.putPixel(-y + cx, x + cy); // Octant 3
            this.putPixel(-x + cx, -y + cy); // Octant 5
            this.putPixel(-y + cx, -x + cy); // Octant 6
            this.putPixel(x + cx, -y + cy); // Octant 8
            this.putPixel(y + cx, -x + cy); // Octant 7
            y++;
            if (decisionOver2 <= 0) {
                decisionOver2 += 2 * y + 1;   // Change in decision criterion for y -> y+1
            } else {
                x--;
                decisionOver2 += 2 * (y - x) + 1;   // Change for y -> y+1, x -> x-1
            }
        }
    }

}
