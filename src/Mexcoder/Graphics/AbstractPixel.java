/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public abstract class AbstractPixel {

    protected BufferedImage buffer;
    protected Graphics p,tg;
    protected Color c,tc;
    protected Component canvas;
    protected int center[];
    protected BufferedImage tempBuff; 
    
   protected  AbstractPixel() {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        p = (Graphics2D) buffer.createGraphics();
        this.setColor(Color.BLACK);
    }
    
    public AbstractPixel(Component canvas){
        this();
        this.setCanvas(canvas);
    }
    
    public final void setCanvas(Component canvas){
        this.canvas = canvas;
        this.tg = canvas.getGraphics();
    }
    

    protected final void putPixel(int x, int y) {
        tg.drawImage(buffer, x, y, canvas);
    }

    public final void setColor(Color c) {
        this.c = c;
        buffer.setRGB(0, 0, c.getRGB());
        
    }
    
    protected void floodFill(Color c){
        Color tmp = this.c;
        this.setColor(c);
        this.floodFill();
        this.setColor(tmp);
    
    }
    
    protected void floodFill() {
        
        
        this.tempBuff = getScreenShot(this.canvas);
        tc = new Color(this.tempBuff.getRGB(center[0],center[1]));
        floodFill (center[0],center[1]);
    }
    
    private BufferedImage getScreenShot(Component panel){
        BufferedImage bi = new BufferedImage(
            panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        panel.paint(bi.getGraphics());
        return bi;
    }
    protected void floodFill(int x,int y) {
        //get color and mark
        if(this.tempBuff.getRGB(x,y) == this.c.getRGB())//si ya esta marcado
            return;
        this.putPixel(x, y);
        floodFill(x-1, y);
        floodFill(x+1, y);
        floodFill(x, y-1);
        floodFill(x, y+1);
        return;
    }
    protected void setCenter(int x,int y){
        if(this.center == null){
            this.center = new int[]{x,y};
        }
        else{
            this.center[0] = x;
            this.center[1] = y;
        }
    }
    
}
