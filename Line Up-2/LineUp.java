//********************************************************************
//  LineUp.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a graphical object.
//********************************************************************

    import java.awt.*;
    import java.util.*;

    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;

public class LineUp extends JComponent //implements Runnable
{
   private final int APPLET_WIDTH = 400;    //Size constants
   private final int APPLET_HEIGHT = 150;
   private final int HEIGHT_MIN = 100;
   private final int VARIANCE = 45;
   Random generator = new Random();
   //Graphics page;

   
   private StickFigure figure1,figure2, figure3, figure4;
   private Floor ground;
   private int running = 0;

   //-----------------------------------------------------------------
   //  Creates several stick figures with varying characteristics.
   //-----------------------------------------------------------------
   public LineUp () //init in applet is like constructor; runs only once
   {                   //Different than start.
      int h1,h2,h3,h4;  // heights of stick figures

      h1 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h2 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h3 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h4 = HEIGHT_MIN + generator.nextInt(VARIANCE);

      
      figure1 = new StickFigure (100, 150, Color.red, h1);
      //x, y, color, height
      figure2 = new StickFigure(150, 150, Color.green, h2);
      figure3 = new StickFigure(200, 150, Color.cyan, h3);
      figure4 = new StickFigure(250, 150, Color.yellow, h4);

      ground = new Floor();


   }

   //-----------------------------------------------------------------
   //  Paints the stick figures on the applet.
   //-----------------------------------------------------------------
   public void paintComponent(Graphics g)
    {
        Graphics2D page = (Graphics2D) g;
       //page = this.page;
       
      ground.draw(page);//behind the figures
      figure1.draw (page);
      figure2.draw (page);
      figure3.draw (page);
      figure4.draw (page);
      //ground.draw(page);// on top of figures

      

      //repaint(); //IMPORTANT LINE
   }

   public void nextFrame()
   {
       figure1.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       figure2.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       figure3.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       figure4.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       running ++;
       ground.setX(running);
       
       repaint();

   }

}
