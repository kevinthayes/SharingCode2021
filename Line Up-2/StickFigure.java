    //********************************************************************
    //  StickFigure.java       Author: Lewis/Loftus/Cocking
    //
    //  Represents a graphical stick figure.
    //********************************************************************

    import java.awt.*;
    import java.util.*;

    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;

public class StickFigure extends JComponent
    {
       private int baseX;     // center of figure
       private int baseY;     // floor (bottom of feet)
       private Color color;   // color of stick figure
       private int height;    // height of stick figure
       Random generator = new Random();

       //-----------------------------------------------------------------
       //  Sets up the stick figure's primary attributes.
       //-----------------------------------------------------------------
       public StickFigure (int center, int bottom, Color shade, int size)
       {
          baseX = center;
          baseY = bottom;
          color = shade;
          height = size;
       }

       /**
        * setHeight method
        */
       public void setHeight(int size){
           
           height = size;
           //System.out.println(color);
          
       }

       /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        // invoke the draw method
        // ...
        draw(g2);


    }

    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void nextFrame()
    {
        // update the objects in the cityscape so they are animated
        // ...
        height = 100 +generator.nextInt(45);



        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }

       //-----------------------------------------------------------------
       //  Draws this figure relative to baseX, baseY, and height.
       //-----------------------------------------------------------------
       public void draw (Graphics2D page)
       {
          int top = baseY - height;  // top of head
                                     //y needs to move, not height.

          page.setColor (color);
          //                 x     y    h  w
          page.drawOval(baseX-10, top, 20, 20);// head

          page.drawLine(baseX, top+20, baseX, baseY-30);// trunk
                                    //remember, increase y actually moves closer to bottom

          page.drawLine (baseX, baseY-30, baseX-15, baseY);  // legs
          page.drawLine (baseX, baseY-30, baseX+15, baseY);

          page.drawLine (baseX, baseY-70, baseX-25, baseY-70);  // arms
          page.drawLine (baseX, baseY-70, baseX+20, baseY-85);

       }

       
        
    }
