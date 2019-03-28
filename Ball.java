import java.awt.Graphics2D;

public class Ball
{
   private final int BALL_DIAMETER = 30;
   private final int TOP_LEFT_BORDER = 0;
   private int BallX = 0;
   private int BallY = 0;
   private int MoveX = 1;
   private int MoveY = 1;
   
   private Game game;
   
   // Create a ball object with a reference to the game board
   public Ball(Game game)
   {
      this.game = game;
   }
   
   void move()
   {
      // If ball runs into the left border, reverse direction
      if(BallX + MoveX < TOP_LEFT_BORDER)
      {
         MoveX = 1;
      }
      
      // If the ball runs into the right border, reverse direction
      else if(BallX + MoveX > game.getWidth() - BALL_DIAMETER)
      {
         MoveX = -1;
      }
      
      // If ball runs into the top border, reverse direction
      if(BallY + MoveY < TOP_LEFT_BORDER)
      {
         MoveY = 1;
      }
      
      // If the ball runs into the bottom border, reverse direction
      else if(BallY + MoveY > game.getHeight() - BALL_DIAMETER)
      {
         MoveY = -1;
      }
      // Set the movement direction based on the previous decisions
      
      BallX = BallX + MoveX;
      BallY = BallY + MoveY;
   }
   
   // Create the ball/circle
   public void paint(Graphics2D g)
   {
      // Paint new position of the ball
      g.fillOval(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
   }
}