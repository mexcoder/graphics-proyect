/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import Mexcoder.Graphics.BrensenhamCircle;
import Mexcoder.Graphics.BrensenhamLine;
import Mexcoder.Graphics.SimpleCircle;
import Mexcoder.Graphics.DDALine;
import Mexcoder.Graphics.Elipse;
import Mexcoder.Graphics.MidpointCircle;
import Mexcoder.Graphics.MidpointLine;
import Mexcoder.Graphics.SimpleLine;
import Mexcoder.Graphics.Pixel;
import Mexcoder.Graphics.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
    BufferedImage b;

    public test() {
        super("test: linea");
        this.setVisible(true);
        b = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        l = new SimpleLine(b);
        ll = new DDALine(b);
        lll = new BrensenhamLine(b);
        llll = new MidpointLine(b);
        r = new Rectangle(b);
        c = new SimpleCircle(b);
        cc = new BrensenhamCircle(b);
        ccc = new MidpointCircle(b);
        
        doDrawing();

    }
    
    protected void doDrawing(){
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

       Elipse l = new Elipse(b);
       l.draw(10, 400, 310, 550);
       l.floodFill(Color.GREEN);
    }

    public void paint(Graphics g) {

       g.drawImage(b,0,0,this);
    }

    public static void main(String[] args) {
        new test();
    }
}
