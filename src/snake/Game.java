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
	
	//Background color for the applet
	private final Color BACK_COLOR = Color.BLACK;
	
	//Unsure why we do this
	Graphics g; 
	Image img;
	
	@Override
	/**
	 * Creates the applet with given width and height
	 */
	public void init()
	{
		this.resize(WIDTH,HEIGHT);
		
		img = createImage(WIDTH, HEIGHT);
		g = img.getGraphics();
	}
	
	@Override
	/**
	 * Gives the applet the default color background
	 */
	public void paint(Graphics graph)
	{
		g.setColor(BACK_COLOR);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		graph.drawImage(img, 0, 0, null);
	}
	
	@Override
	public void update(Graphics graph)
	{
		paint(graph);
	}
	
	public void repaint(Graphics graph)
	{
		
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if(event.getKeyCode() == KeyEvent.VK_UP)
		{
			
		}
		else if(event.getKeyCode() == KeyEvent.VK_DOWN)
		{
			
		}
		else if(event.getKeyCode() == KeyEvent.VK_DOWN)
		{
			
		}
		else if(event.getKeyCode() == KeyEvent.VK_DOWN)
		{
			
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
