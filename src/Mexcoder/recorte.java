/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import Mexcoder.Graphics.BoundedCircle;
import Mexcoder.Graphics.Rectangle;
import Mexcoder.Graphics.SimpleCircle;
import Mexcoder.Graphics.SimpleLine;
import Mexcoder.Graphics.boundedLine;
import Mexcoder.Graphics.boundedRectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public class recorte extends Ventana{
    
    //para la ventana 2
    boundedLine sla;
    BoundedCircle sca;
    boundedRectangle ra;
    BufferedImage ba;
    

    public recorte() {
        super("recorte");
        ba = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
        sla = new boundedLine(ba);
        sca = new BoundedCircle(ba);
        ra = new boundedRectangle(ba);
        
        //ventana 2
        
        new Rectangle(ba).draw(100, 100, 700, 500,Color.RED);
        
        ra.bountToRect(100, 100, 700, 500);
        sla.bountToRect(100, 100, 700, 500);
        sca.bountToRect(100, 100, 700, 500);
        
        sla.draw(110, 110, 710, 510);
        sla.draw(10,10,10,400);
        
        ra.draw(10, 200, 210, 100,Color.ORANGE);
        ra.draw(600, 250, 800, 350,Color.ORANGE);
        
        ra.draw(300, 200, 500, 400,Color.ORANGE);
        
        sca.setColor(Color.green);
        sca.drawAtCenter(100, 100, 100);
        sca.drawAtCenter(100, 500, 100);
        sca.drawAtCenter(700, 100, 100);
        sca.drawAtCenter(700, 500, 100);
    }
    
     public void paint(Graphics g) {

        g.drawImage(ba, 0, 0, this);
    }
    
}
