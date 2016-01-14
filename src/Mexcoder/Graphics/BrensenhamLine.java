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
public class BrensenhamLine extends SimpleLine {

    public BrensenhamLine(BufferedImage c) {
        super(c);
    }
    
    public void setMask(byte m){
        this.mask = m;
    };

    @Override
    public void draw(int x0, int y0, int x1, int y1) {
//        int dx = Math.abs(x1 - x0);
//        int a = 2 * Math.abs(y1 - y0);
//        int b = a - 2 * dx;
//        int p = a - dx;
//
//        int x = x0, y = y0;
//
//        while (x != x1) {
//            if (p < 0) {
//
//                this.putPixel(++x, y);
//                p += a;
//            } else {
//                this.putPixel(x++, y++);
//                p += b;
//            }
//
//        }

        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = (x1 - x0);
        dy = (y1 - y0);

        /* determinar que punto usar para empezar, cual para terminar */
        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        } else {
            stepy = 1;
        }

        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        } else {
            stepx = 1;
        }

        x = x0;
        y = y0;
        this.putPixel(x0, y0);
        /* se cicla hasta llegar al extremo de la línea */
        if (dx > dy) {
            p = 2 * dy - dx;
            incE = 2 * dy;
            incNE = 2 * (dy - dx);
            while (x != x1) {
                x = x + stepx;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepy;
                    p = p + incNE;
                }
                this.putPixel(x, y);
            }
        } else {
            p = 2 * dx - dy;
            incE = 2 * dx;
            incNE = 2 * (dx - dy);
            while (y != y1) {
                y = y + stepy;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepx;
                    p = p + incNE;
                }
                this.putPixel(x, y);
            }
        }
    }
}
