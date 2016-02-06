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
public class lineWidth extends BrensenhamLine {

    public lineWidth(BufferedImage c) {
        super(c);
    }

    protected int width = 1;

    public void setWidth(int w) {
        this.width = w;
    }

    @Override
    public void draw(int x0, int y0, int x1, int y1) {

        if (x0 == x1) {
            for (int i = 0; i < this.width; i++) {
                super.draw(x0 + i, y0, x1 + i, y1);

            }

        } else {
            int i;
            for (i = 0; i < this.width; i++) {
                super.draw(x0, y0 + i, x1, y1 + i);

            }
        }
    }

}
