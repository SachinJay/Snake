package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Food
{
	private Integer x;
	private Integer y; 
	private int score;
		
	private Snake snake; 
	
	public Food(Snake s)
	{
		x = (int)(Math.random() * (Constants.WIDTH - Constants.FOOD_SIZE + 1) );
		y = (int)(Math.random() * (Constants.HEIGHT - Constants.FOOD_SIZE + 1) );
		snake = s; 
	}
	
	/**
	 * Places the food in a new place, further modification to give it new color
	 */
	public void randomize()
	{
		//TODO randomize the color too
		x = (int)(Math.random() * (Constants.WIDTH - Constants.FOOD_SIZE + 1) );
		y = (int)(Math.random() * (Constants.HEIGHT - Constants.FOOD_SIZE + 1) );
	}
	
	/**
	 * 
	 * @return true if the snake ate the food
	 */
	public Boolean hasBeenEaten()
	{
		//Add the offset to get the center of the snake's head
		int headX = snake.getHeadX() + (Constants.PT_SIZE/2);
		int headY = snake.getHeadY() + (Constants.PT_SIZE/2);
		
		if(headX >= x-1 && headX <= (x + Constants.FOOD_SIZE + 1))
		{
			if(headY >= y-1 && headY <= (y + Constants.FOOD_SIZE + 1) )
			{
				this.randomize();
				score++;
				snake.setIsEating(true);
				return true;
			}
		}
		return false; 
	}
	
	
	/**
	 * 
	 * @return the score
	 */
	public Integer getScore()
	{
		return score;
	}
	
	public void draw(Graphics g)
	{
		//TODO: I want to make this a random color, do this later after everything is working
		g.setColor(Color.green);
		
		//TODO I want to make this a circle later
		//I think that might affec the logic for snake getting it but the other half of me says
		//Nah it'll be fine because the snake can't attack diagonally
		g.fillRect(x, y, Constants.FOOD_SIZE, Constants.FOOD_SIZE);
	}
}
