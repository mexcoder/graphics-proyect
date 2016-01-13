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

    public test() {
        super("test: linea");
        this.setVisible(true);
        l = new SimpleLine(this);
        ll = new DDALine(this);
        lll = new BrensenhamLine(this);
        llll = new MidpointLine(this);
        r = new Rectangle(this);
        c = new SimpleCircle(this);
        cc = new BrensenhamCircle(this);
        ccc = new MidpointCircle(this);

    }

    public void paint(Graphics g) {

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

       Elipse l = new Elipse(this);
       l.draw(10, 400, 310, 550);
       l.floodFill(Color.GREEN);
        /*l.draw(100, 100, 400, 400,Color.BLUE);
        l.draw(100, 400, 400, 400,Color.blue);
        ll.draw(100, 400, 400, 100, Color.red);
        l.draw(100,400,100,100,Color.BLUE);
        ll.draw(400, 300, 100, 300, Color.red);
        
        ll.draw(450, 400, 150, 100,Color.red);
        //new Pixel(this).draw(150, 100, Color.BLUE);
        
        new Rectangle(this).draw(450,100,650,300,Color.GREEN);
        
        new SimpleCircle(this).draw(450, 100, 650, 300,Color.ORANGE);
        new SimpleCircle(this).draw(500, 150, 600, 250,Color.YELLOW);*/
    }

    public static void main(String[] args) {
        new test();
    }
}
