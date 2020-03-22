package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Food
{
	/**coordinates of center of food	 */
	private Integer x;
	private Integer y; 
	
	/**Number of food objects eaten by snake so far */
	private int score;
		
	private Snake snake; 
	
	/**
	 * 
	 * @param s the snake that will eat the food
	 */
	public Food(Snake s)
	{
		x = (int)(Math.random() * (Constants.WIDTH - Constants.FOOD_SIZE + 1) );
		y = (int)(Math.random() * (Constants.HEIGHT - Constants.FOOD_SIZE + 1) );
		snake = s; 
	}
	
	/**
	 * Places the food in a new place
	 */
	public void randomize()
	{
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
		//Gets a random color from the color array 
		int col = (int)(Math.random() * Constants.NUM_FOOD_COLORS);
		g.setColor(Constants.FOOD_COLORS[col]);
		
		g.fillOval(x, y, Constants.FOOD_SIZE, Constants.FOOD_SIZE);
	}
}
