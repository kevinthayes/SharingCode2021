import java.awt.*;
import java.util.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h;
    private int running;

    /**
     * Constructor for objects of class Floor
     */
    public Floor()
    {
        x = 50;
        y = 125;
        w = 250;
        h = 50;
    }

    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void run()
    {
        // update the objects in the cityscape so they are animated
        // ...
        while(true)
        {
            if (running % 2 == 0)
                x +=20;
            else
                x -= 20;

            running++;

            try
            {
                Thread.sleep(200);
            }
            catch( InterruptedException e )
            {
            }
        }
    }

    //-----------------------------------------------------------------
    //  Draws this figure relative to baseX, baseY, and height.
    //-----------------------------------------------------------------
    public void draw (Graphics2D page)
    {
        page.setColor(Color.black);
        page.fillRect(x, y, w, h);
    }

}
