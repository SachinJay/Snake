package snake;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Applet implements Runnable, KeyListener
{	
	//The offscreen graphics
	Graphics gfx; 
	Image img;
	Thread thread;
	Snake snake; 
	Boolean gameOver;
	
	@Override
	/**
	 * Creates the applet with given width and height
	 */
	public void init()
	{
		this.resize(Constants.WIDTH,Constants.HEIGHT);
		
		img = createImage(Constants.WIDTH, Constants.HEIGHT);
		gfx = img.getGraphics();
		
		this.addKeyListener(this);
		
		//initialize the snake according to parameters set in the snake class
		snake = new Snake();
		gameOver = false; 
		
		//instantiate the thread, takes in a runnable object, well the game itself is runnable
		//so we pass in that
		thread = new Thread(this);
		thread.start();		
	
	}
	
	@Override
	/**
	 * Gives the applet the default color background
	 */
	public void paint(Graphics graph)
	{
		gfx.setColor(Constants.BACKGROUND_COLOR);
		gfx.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
		
		//takes in the offscreen graphics
		if(!gameOver)
		{
			snake.draw(gfx);
		}
		else 
		{
			gfx.setColor(Constants.END_COLOR);
			gfx.drawString("You Lose", Constants.WIDTH/2, Constants.HEIGHT/2);
		}
		
		//used to draw the offscreen graphics onto the screen, must be the last line as a result
		graph.drawImage(img, 0, 0, null);
	}
	
	@Override
	public void update(Graphics graph)
	{
		paint(graph);
	}
	
	public void repaint(Graphics graph)
	{
		paint(graph);
	}

	public void checkGameOver()
	{
		if(snake.getHeadX() < 0 || snake.getHeadX() > (Constants.WIDTH - Constants.PT_SIZE))
		{
			gameOver = true;
		}
		if(snake.getHeadY() < 0 || snake.getHeadY() > (Constants.HEIGHT - Constants.PT_SIZE))
		{
			gameOver = true;
		}
		if(snake.snakeHitSelf())
		{
			gameOver = true;
		}
	}
	
	@Override
	public void run()
	{
		//run method is an infinite loop of drawing
		//Just like how movies work, a lot of still images played quickly 
		while(true)
		{
			
			if(!gameOver)
			{
				snake.move();
				this.checkGameOver();
			}
			this.repaint();
			try
			{
				Thread.sleep(Constants.SLEEP_TIME);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		
		Integer code = event.getKeyCode();
		
		Boolean snakeUp = snake.getyDir() == Constants.UP;
		Boolean snakeDown = snake.getyDir() == Constants.DOWN;
		Boolean snakeLeft = snake.getxDir() == Constants.LEFT;
		Boolean snakeRight = snake.getxDir() == Constants.RIGHT;
		
		//If snake is not moving (i.e. if we are at the very beginning of the game)
		//Only start the game if the arrow key they hit is not left (because this would cause 
		//self intersection)
		if(!snake.getIsMoving())
		{
			if(code == KeyEvent.VK_UP || code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_DOWN)
			{
				snake.setIsMoving(true);
			}
				
		}
		
		//The following are cases for different key presses during the game
		//Note that because the classic snake game does not allow diagonal movemet, 
		//whenever you move in x direction, the y direction is set to 0, and vice versa
		if(code == KeyEvent.VK_UP)
		{
			if(!snakeDown)
			{
				snake.setyDir(Constants.UP);
				snake.setxDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(!snakeUp) 
			{ 
				snake.setyDir(Constants.DOWN);
				snake.setxDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(!snakeRight)
			{
				snake.setxDir(Constants.LEFT);
				snake.setyDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(!snakeLeft) 
			{ 
				snake.setxDir(Constants.RIGHT);
				snake.setyDir(0);
			}
		}		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
