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
public class MidpointCircle extends BrensenhamCircle {

    public MidpointCircle(BufferedImage c) {
        super(c);
    }

    @Override
    public void drawAtCenter(int cx, int cy, int r) {

        float d = /*1 - r;*/(5 - r * 4)/4;
        int x = r;
        int y = 0;

        while (y <= x) {
            this.putPixel((int)x + cx, (int)y + cy); // Octant 1
            this.putPixel((int)y + cx, (int)x + cy); // Octant 2
            this.putPixel((int)-x + cx, (int)y + cy); // Octant 4
            this.putPixel((int)-y + cx, (int)x + cy); // Octant 3
            this.putPixel((int)-x + cx, (int)-y + cy); // Octant 5
            this.putPixel((int)-y + cx, (int)-x + cy); // Octant 6
            this.putPixel((int)x + cx, (int)-y + cy); // Octant 8
            this.putPixel((int)y + cx, (int)-x + cy); // Octant 7

            if (d < 0) {
                    d += 2 * y + 1;
            } else {
                    d += 2 * (y - x) + 1;
                    x--;
            }
            y++;

        }
    }

}
