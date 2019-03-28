import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet
{
   // Create a reference to the game object
   private Game game;
   // Set the vertical position of racquet from bottom of window
   private final int RACQUET_Y = game.GAME_HEIGHT -70;
   // Constants for size of racquet
   private static final int WIDTH = 60;
   private static final int HEIGHT = 10;
   
   // Store horizontal position
   int RacquetX = 0;
   // Store horizontal movement
   int MoveX = 0;
   
   // Create object with Game reference
   public Racquet(Game game)
   {
      this.game = game;
   }
   
   public void move()
   {
      // If the racquet is not outside the left or right border, allow movement
      if (RacquetX + MoveX > 0 && RacquetX + MoveX < game.getWidth() - WIDTH)
      {
         RacquetX = RacquetX + MoveX;
      }
   }
   
   // Draw racquet rectangle
   public void paint(Graphics2D g)
   {
      g.fillRect(RacquetX, RACQUET_Y, WIDTH, HEIGHT);
   }
   
   // Stop movement when key is released
   public void keyReleased(KeyEvent e)
   {
      MoveX = 0;
   }
   
   // Get which cursor key is pressed, change horizontal movement variable
   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode() == KeyEvent.VK_LEFT)
         MoveX = -1;
      if(e.getKeyCode() == KeyEvent.VK_RIGHT)
         MoveX = 1;
   }
}