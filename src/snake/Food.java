package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Food
{
	private Integer x;
	private Integer y; 
	private Integer score;
	
	private final Integer SIZE = 6; 
	
	private Snake snake; 
	
	public Food(Snake s)
	{
		snake = s; 
	}
	
	
	/**
	 * 
	 * @return the score
	 */
	public Integer getScore()
	{
//		x = (int)(Math.random() + ())
		return score;
	}
	
	public void draw(Graphics g)
	{
		//TODO: I want to make this a random color, do this later after everything is working
		g.setColor(Color.green);
		
		//TODO I want to make this a circle later
		//I think that might affec the logic for snake getting it but the other half of me says
		//Nah it'll be fine because the snake can't attack diagonally
		g.fillRect(x, y, SIZE, SIZE);
	}
}
