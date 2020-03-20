package snake;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Applet implements Runnable, KeyListener
{
	
	private final Integer WIDTH = 500;
	private final Integer HEIGHT = 500;
	private final Long SLEEP_TIME = (long) 30;
	
	//directions
	private final Integer UP = -1; 
	private final Integer DOWN = 1; 
	private final Integer LEFT = -1;
	private final Integer RIGHT = 1; 
	
	//Background color for the applet
	private final Color BACK_COLOR = Color.BLACK;
	
	//Color for game over screen
	private final Color END_COLOR = Color.RED;
	
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
		this.resize(WIDTH,HEIGHT);
		
		img = createImage(WIDTH, HEIGHT);
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
		gfx.setColor(BACK_COLOR);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		
		//takes in the offscreen graphics
		if(!gameOver)
		{
			snake.draw(gfx);
		}
		else 
		{
			gfx.setColor(END_COLOR);
			gfx.drawString("You Lose", WIDTH/2, HEIGHT/2);
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
		if(snake.getHeadX() < 0 || snake.getHeadX() > (WIDTH - snake.getPointSize()))
		{
			gameOver = true;
		}
		if(snake.getHeadY() < 0 || snake.getHeadY() > (HEIGHT - snake.getPointSize()))
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
				Thread.sleep(SLEEP_TIME);
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
		
		Boolean snakeUp = snake.getyDir() == UP;
		Boolean snakeDown = snake.getyDir() == DOWN;
		Boolean snakeLeft = snake.getxDir() == LEFT;
		Boolean snakeRight = snake.getxDir() == RIGHT;
		
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
				snake.setyDir(UP);
				snake.setxDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(!snakeUp) 
			{ 
				snake.setyDir(DOWN);
				snake.setxDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(!snakeRight)
			{
				snake.setxDir(LEFT);
				snake.setyDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(!snakeLeft) 
			{ 
				snake.setxDir(RIGHT);
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
