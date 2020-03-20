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
	private final Long SLEEP_TIME = (long) 50;
	
	//directions
	private final Integer UP = -1; 
	private final Integer DOWN = 1; 
	private final Integer LEFT = -1;
	private final Integer RIGHT = 1; 
	
	//Background color for the applet
	private final Color BACK_COLOR = Color.BLACK;
	
	//The offscreen graphics
	Graphics g; 
	Image img;
	Thread thread;
	Snake snake; 
	
	@Override
	/**
	 * Creates the applet with given width and height
	 */
	public void init()
	{
		this.resize(WIDTH,HEIGHT);
		
		img = createImage(WIDTH, HEIGHT);
		g = img.getGraphics();
		
		//instantiate the thread, takes in a runnable object, well the game itself is runnable
		//so we pass in that
		thread = new Thread(this);
		thread.start();
		
		//initialize the snake according to parameters set in the snake class
		snake = new Snake();
	}
	
	@Override
	/**
	 * Gives the applet the default color background
	 */
	public void paint(Graphics graph)
	{
		g.setColor(BACK_COLOR);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//takes in the offscreen graphics
		snake.draw(g);
		
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

	@Override
	public void run()
	{
		//run method is an infinite loop of drawing
		//Just like how movies work, a lot of still images played quickly 
		for(;;)
		{
			
			snake.move();
			
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
		Boolean snakeUp = snake.getyDir() == UP;
		Boolean snakeDown = snake.getyDir() == DOWN;
		Boolean snakeLeft = snake.getxDir() == LEFT;
		Boolean snakeRight = snake.getxDir() == RIGHT;
		
		
		if(event.getKeyCode() == KeyEvent.VK_UP)
		{
			if(snake.getyDir() != DOWN)
			{
				snake.setyDir(UP);
				snake.setxDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(snake.getyDir() != UP) 
			{ 
				snake.setyDir(DOWN);
				snake.setxDir(0);
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(snake.getxDir() != RIGHT)
			{
				snake.setxDir(LEFT);
				snake.setyDir(0);
				
			}
		}
		 if(event.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(snake.getxDir() != LEFT) 
			{ 
				snake.setxDir(RIGHT);
				snake.setyDir(0);
			
			}
		}
		
		//No else branch included here becaues there are no other valid commands besides these
		
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
