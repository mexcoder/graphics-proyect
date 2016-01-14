/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JuanAntonio
 */
public abstract class AbstractPixel {

    protected BufferedImage buffer;
    protected Color c;
    int tc;
    protected int center[];
    protected byte mask = (byte)0b11111111;
    protected int steeps = 0;

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

        if (this.mask == 0xff ||((this.mask >> (this.steeps++ % 8)) & 0x1) != 0) {
            buffer.setRGB(x, y, this.c.getRGB());
        }
    }

    public final void setColor(Color c) {
        this.c = c;
    }

    protected void floodFill(Color c) {
        Color tmp = this.c;
        this.setColor(c);
        this.floodFill();
        this.setColor(tmp);

    }

    protected void floodFill() {

        tc = this.buffer.getRGB(center[0], center[1]);
        floodFill(center[0], center[1]);
    }

    protected void floodFill(int x, int y) {
        //wont work recursive
        LinkedList<Point> list = new LinkedList<Point>();

        list.add(new Point(x, y));
        Point p;

        while (!list.isEmpty()) {
            p = list.pop();
            x = p.x;
            y = p.y;

            //get color and mark
            if (this.buffer.getRGB(x, y) != this.tc)//si ya esta marcado
            {
                continue;
            }

            this.putPixel(x, y);
            list.add(new Point(x, y));
            list.add(new Point(x - 1, y));
            list.add(new Point(x + 1, y));
            list.add(new Point(x, y - 1));
            list.add(new Point(x, y + 1));
        }

    }

    protected void setCenter(int x, int y) {
        if (this.center == null) {
            this.center = new int[]{x, y};
        } else {
            this.center[0] = x;
            this.center[1] = y;
        }
    }

    protected void scanLine() {
        tc = this.buffer.getRGB(center[0], center[1]);
        scanLine(center[0], center[1]);
    }

    protected void scanLine(Color c) {
        Color tmp = this.c;
        this.setColor(c);
        this.scanLine();
        this.setColor(tmp);

    }

    private void scanLine(int x, int y) {

        //get to the corner
        while (this.buffer.getRGB(x - 1, y - 1) == this.tc)//si ya esta marcado
        {
            x--;
            y--;
        }

        int startx = x;

        while (this.buffer.getRGB(x, y) == this.tc)//si ya esta marcado
        {
            while (this.buffer.getRGB(x, y) == this.tc)//si ya esta marcado
            {
                this.putPixel(x++, y);
            }
            y++;
            x = startx;
        }

    }

}
