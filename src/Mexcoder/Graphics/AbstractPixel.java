/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public abstract class AbstractPixel {

    protected BufferedImage buffer;
    protected Color c, tc;
    protected int center[];

    protected AbstractPixel() {
        this.setColor(Color.BLACK);
    }

    protected AbstractPixel(BufferedImage canvas) {
        this();
        this.setCanvas(canvas);
    }

    public final void setCanvas(BufferedImage canvas) {
        this.buffer = canvas;
    }

    protected final void putPixel(int x, int y) {
        buffer.setRGB(x, y, this.c.getRGB());
    }

    public final void setColor(Color c) {
        this.c = c;
        buffer.setRGB(0, 0, c.getRGB());

    }

    protected void floodFill(Color c) {
        Color tmp = this.c;
        this.setColor(c);
        this.floodFill();
        this.setColor(tmp);

    }

    protected void floodFill() {

        tc = new Color(this.buffer.getRGB(center[0], center[1]));
        floodFill(center[0], center[1]);
    }

    protected void floodFill(int x, int y) {
        //get color and mark
        if (this.buffer.getRGB(x, y) == this.c.getRGB())//si ya esta marcado
        {
            return;
        }
        this.putPixel(x, y);
        floodFill(x - 1, y);
        floodFill(x + 1, y);
        floodFill(x, y - 1);
        floodFill(x, y + 1);
        
    }

    protected void setCenter(int x, int y) {
        if (this.center == null) {
            this.center = new int[]{x, y};
        } else {
            this.center[0] = x;
            this.center[1] = y;
        }
    }

}
