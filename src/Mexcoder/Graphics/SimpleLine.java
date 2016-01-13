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
public class SimpleLine extends AbstractPixel {

    public SimpleLine(BufferedImage c) {
        super(c);
    }

    public void draw(int x0, int y0, int x1, int y1, Color c) {
        Color tmp = this.c;
        this.setColor(c);
        this.draw(x0, y0, x1, y1);
        this.setColor(tmp);
    }

    public void draw(int x0, int y0, int x1, int y1) {

        if (x0 != x1) {

            float m = (float)(y1 - y0) / (float)(x1 - x0);
            float b = y1 - m * x1;
            float x, y;
            if (x0 > x1) {
                for (x = x0; x != x1; x--) {
                    y = m * x + b;
                    this.putPixel((int)x, (int)y);
                }
            } else {
                for (x = x0; x != x1; x++) {
                    y = m * x + b;
                    this.putPixel((int)x, (int)y);
                }
            }

        } else {

            float m = (float)(x1 - x0) / (float)(y1 - y0);
            float b = x1 - m * y1;
            float x, y;

            if (y0 > y1) {
                for (y = y0; y != y1; y--) {
                    x = m * y + b;
                    this.putPixel((int)x, (int)y);
                }
            } else {

                for (y = y0; y != y1; y++) {
                    x = m * y + b;
                    this.putPixel((int)x, (int)y);
                }

            }

        }

    }

}
