import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel
{
   // Constants for the size of the JFrame
   final static int GAME_WIDTH = 300;
   final static int GAME_HEIGHT = 400;
   
   // Variables for the speed of the game
   static int gameSpeed = 9;
   // Create a Ball object
   Ball ball = new Ball(this);
   
   Racquet racquet = new Racquet(this);
   
   // Construct the Game application
   public Game()
   {
      // Add KeyListener to the application
      addKeyListener(new KeyListener()
      {
         @Override
         public void keyTyped(KeyEvent e){}
         
         @Override
         public void keyReleased(KeyEvent e) 
         {
            racquet.keyReleased(e);
         }
         
         @Override
         public void keyPressed(KeyEvent e) 
         {
            racquet.keyPressed(e);
         }
      });
      
      // Allow focus to JPanel
      setFocusable(true);
         
   }
   
   // Call the Ball.move method
   private void move()
   {
      ball.move();
      racquet.move();
   }
   
   @Override
   public void paint(Graphics g)
   {
      // Clear JPanel
      super.paint(g);
      Graphics2D g2d = (Graphics2D) g;
      // Turn on anti aliasing, making the circle bitmap smoother
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
         RenderingHints.VALUE_ANTIALIAS_ON);
      // Paint the ball on the screen
      ball.paint(g2d); 
      // Override the racquet paint method
      racquet.paint(g2d);  
    }
    
    // Games over called from Ball object
    public void gameOver()
    {
      JOptionPane.showMessageDialog(this, "Game Over", "Game Over", 
      JOptionPane.YES_NO_OPTION);
      System.exit(ABORT);
    }
   
   public static void main(String[] args) throws InterruptedException
   {
      JFrame frame = new JFrame("Simple Pong");
      Game game = new Game();
      frame.add(game);
      frame.setSize(GAME_WIDTH, GAME_HEIGHT);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // An infinite "Game Loop"
      while(true)
      {
         // Move the ball
         game.move();
         // Repaint the JPanel
         game.repaint();
         // Sleep this thread for 10 ms
         // Other threads can process, redrawing the screen
         Thread.sleep(gameSpeed);
      }
   }
}