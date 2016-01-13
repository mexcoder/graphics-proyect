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
public class DDALine extends SimpleLine {

    public DDALine(Component c) {
        super(c);
    }

    @Override
    public void draw(int x0, int y0, int x1, int y1) {

        float dx = x1 - x0;
        float dy = y1 - y0;
        float steeps;

        if (Math.abs(dx) > Math.abs(dy)) {
            steeps = Math.abs(dx);
        } else {
            steeps = Math.abs(dy);
        }

        float incx = dx / steeps, incy = dy / steeps;

        double x = x0, y = y0;

        this.putPixel((int)x,(int) y);

        for (int i = 1; i != steeps; i++) {
            x += incx;
            y += incy;

            this.putPixel((int)x,(int) y);
        }

    }

}
