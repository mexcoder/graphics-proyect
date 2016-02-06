/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import Mexcoder.Graphics.BrensenhamCircle;
import Mexcoder.Graphics.BrensenhamLine;
import Mexcoder.Graphics.CircleWidth;
import Mexcoder.Graphics.SimpleCircle;
import Mexcoder.Graphics.DDALine;
import Mexcoder.Graphics.Elipse;
import Mexcoder.Graphics.MidpointCircle;
import Mexcoder.Graphics.MidpointLine;
import Mexcoder.Graphics.SimpleLine;
import Mexcoder.Graphics.Pixel;
import Mexcoder.Graphics.Rectangle;
import Mexcoder.Graphics.lineWidth;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanAntonio
 */
public class test extends Ventana {

    SimpleLine l;
    DDALine ll;
    BrensenhamLine lll;
    MidpointLine llll;
    Rectangle r;
    SimpleCircle c;
    BrensenhamCircle cc;
    MidpointCircle ccc;
    BufferedImage b,ba;
    Elipse e;
    lineWidth lw;
    CircleWidth cw;

    Thread renderer;
    boolean render = true;

    @Override
    protected void appExit() {
        render = false;

    }

    public test() {
        super("test: linea");
        this.setVisible(true);
        b = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        l = new SimpleLine(b);
        ll = new DDALine(b);
        lll = new BrensenhamLine(b);
        llll = new MidpointLine(b);
        e = new Elipse(b);
        r = new Rectangle(b);
        c = new SimpleCircle(b);
        cc = new BrensenhamCircle(b);
        ccc = new MidpointCircle(b);
        lw = new lineWidth(b);
        cw = new CircleWidth(b);
        
        
        
        
        Ventana i = this;
        
        
       
        
        doDrawing();
        this.setVisible(true);
        
        //ventana 2
        Ventana a = new recorte();
        a.setVisible(true);
        
        new Thread(new Runnable() {
            public void run() {
                //while (render) {
                    try {
                        Thread.sleep(600);
                        i.repaint();
                        a.repaint();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //}

            }
        }).run();

    }

    protected void doDrawing() {
        //x0 --> x1 inclinada
        l.draw(10, 40, 310, 140, Color.RED);
        ll.draw(10, 50, 310, 150, Color.GREEN);
        lll.draw(10, 60, 310, 160, Color.BLUE);
        llll.draw(10, 70, 310, 170, Color.orange);
        //x0 --> x1 recta
        l.draw(10, 180, 310, 180, Color.RED);
        ll.draw(10, 190, 310, 190, Color.GREEN);
        lll.draw(10, 200, 310, 200, Color.BLUE);
        llll.draw(10, 210, 310, 210, Color.orange);
        //x1 <-- x0 inclinada
        l.draw(310, 220, 10, 320, Color.RED);
        ll.draw(310, 230, 10, 330, Color.GREEN);
        lll.draw(310, 240, 10, 340, Color.BLUE);
        llll.draw(310, 250, 10, 350, Color.orange);
        //x1 <-- x0 recta
        l.draw(310, 360, 10, 360, Color.RED);
        ll.draw(310, 370, 10, 370, Color.GREEN);
        lll.draw(310, 380, 10, 380, Color.BLUE);
        llll.draw(310, 390, 10, 390, Color.orange);

        r.draw(350, 40, 750, 440);
        r.draw(650, 340, 450, 140);

        c.draw(350, 40, 750, 440, Color.RED);
        cc.draw(650, 340, 450, 140, Color.GREEN);
        ccc.draw(400, 90, 700, 390, Color.orange);

        e.draw(10, 400, 310, 550);
        e.draw(30, 420, 290, 530);
        e.draw(50, 440, 270, 510);
        e.floodFill(Color.GREEN);

        r.draw(350, 450, 450, 550);
        r.scanLine(Color.ORANGE);

        r.setMask((byte) 0xc3);
        r.draw(460, 450, 560, 550);
        r.setMask((byte) 0xff);

        lll.setMask((byte) 0xc3);
        lll.draw(460, 450, 560, 550);
        lll.draw(560, 450, 460, 550);
        lll.setMask((byte) 0xff);

        lw.setWidth(10);

        lw.draw(570, 450, 670, 450);
        lw.draw(570, 450, 570, 550);
        lw.draw(570, 550, 670, 550);
        lw.draw(670, 450, 670, 559);
        lw.draw(570, 450, 670, 550);
        
        cw.setWidth(10);
        cw.drawAtCenter(550, 240, 50);
    }

    public void paint(Graphics g) {

        g.drawImage(b, 0, 0, this);
    }

    public static void main(String[] args) {
        new test();
    }
}
