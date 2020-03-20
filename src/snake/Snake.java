package snake;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * 
 * @author Sachin Devasahayam
 *
 * Uses an array list of points in order to represent the snake
 */
public class Snake
{		
	/**
	 * Represents the snake
	 */
	private List<Point> snakeList;
	
	/**
	 * Integer representing x direction the snake is heading in.
	 * -1 means left, 0 not at all, and 1 means right
	 */
	private Integer xDir;
	
	/**
	 * Integer representing y direction the snake is heading in
	 * -1 means up (since (0,0) is a point in the top left)
	 * 0 means not at all, and 1 means down
	 */
	private Integer yDir;
	
	/**
	 * Only false right before game begins, is then immediately set to true when player hits a key
	 */
	private Boolean isMoving;
	
	/**
	 * True when the snake eats a food object
	 */
	private Boolean isEating;
	
	public Snake()
	{
		snakeList = new ArrayList<Point>();
		setxDir(0); 
		setyDir(0); 
		
		setIsMoving(false); 
		isEating = false; 
		
		//Creates the head of the snake
		snakeList.add(new Point(Constants.START_X,Constants.START_Y));
		
		//Loop to fill out the rest of the snake going to the left (by convention)
		for(int i =1; i < Constants.INIT_SNAKE_SIZE; i++)
		{
			snakeList.add(new Point(Constants.START_X - (i*Constants.PT_SIZE),Constants.START_Y));
		}
	}
	
	/**
	 * Called from Game class in order to draw the snake
	 * @param graph the graphics for the snake
	 */
	public void draw(Graphics graph)
	{
		graph.setColor(Constants.SNAKE_COLOR);
		
		//draws in each point of the snake to the desired size
		for(Point p : snakeList)
		{
			graph.fillRect(p.getX(), p.getY(), Constants.PT_SIZE, Constants.PT_SIZE);
		}
	}
	
	/**
	 * Moves the snake
	 */
	public void move()
	{
		
		if(isMoving)
		{
			Point head = snakeList.get(0);
			
			Point newHead = new Point(head.getX() + (xDir * Constants.PT_SIZE), head.getY() + (yDir * Constants.PT_SIZE));
			
			//Use loop to update remaining points
			//Starting from the back we wish to update the points so that they become the points in
			//front of them
			for(int i = snakeList.size()-1; i >= 1; i-- )
			{
				snakeList.set(i, snakeList.get(i-1));
			}
			
			snakeList.set(0, newHead);

		}
	}
	
	/**
	 * 
	 * @return true if the snake self intersected
	 */
	public Boolean snakeHitSelf()
	{
		//In order to check for intersection, just need to check if the head has the same point as
		//any other element in the array list
		
		int headX = snakeList.get(0).getX(); 
		int headY = snakeList.get(0).getY();
		
		for(int i = 1; i < snakeList.size(); i++)
		{
			if(snakeList.get(i).getX() == headX && snakeList.get(i).getY() == headY)
			{
				return true;
			}
		}
		
		return false; 
	}

	/**
	 * @return the xDir
	 */
	public Integer getxDir()
	{
		return xDir;
	}

	/**
	 * @param xDir the x direction to set
	 */
	public void setxDir(Integer xDir)
	{
		this.xDir = xDir;
	}

	/**
	 * @return the yDir
	 */
	public Integer getyDir()
	{
		return yDir;
	}

	/**
	 * @param yDir the y direction to set
	 */
	public void setyDir(Integer yDir)
	{
		this.yDir = yDir;
	}
	
	/**
	 * 
	 * @return The x coordinate of the head of the snake
	 */
	public Integer getHeadX()
	{
		return snakeList.get(0).getX();
	}
	
	/**
	 * 
	 * @return The y coordinate of the head of the snake
	 */
	public Integer getHeadY()
	{
		return snakeList.get(0).getY();
	}

	/**
	 * @return the isMoving
	 */
	public Boolean getIsMoving()
	{
		return isMoving;
	}

	/**
	 * @param isMoving the isMoving to set
	 */
	public void setIsMoving(Boolean isMoving)
	{
		this.isMoving = isMoving;
	}
}
