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
	//Color of the snake
	private final Color SNAKE_COLOR = Color.blue;
	
	//Size of each point in the snake
	private final Integer PT_SIZE = 5;
	
	//The initial size (i.e. number of points that make up) of the snake
	private final Integer SIZE = 25;
	
	//Start coordinates for the head of the snake
	private final Integer START_X = 160;
	private final Integer START_Y = 160;
	
	
	
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
		
		isMoving = false; 
		isEating = false; 
		
		//Creates the head of the snake
		snakeList.add(new Point(START_X,START_Y));
		
		//Loop to fill out the rest of the snake going to the left (by convention)
		for(int i =1; i < SIZE; i++)
		{
			snakeList.add(new Point(START_X - (i*PT_SIZE),START_Y));
		}
	}
	
	/**
	 * Called from Game class in order to draw the snake
	 * @param graph the graphics for the snake
	 */
	public void draw(Graphics graph)
	{
		graph.setColor(SNAKE_COLOR);
		
		//draws in each point of the snake to the desired size
		for(Point p : snakeList)
		{
			graph.fillRect(p.getX(), p.getY(), PT_SIZE, PT_SIZE);
		}
	}
	
	/**
	 * Moves the snake
	 */
	public void move()
	{
		Point head = snakeList.get(0);
		
		Point newHead = new Point(head.getX() + (xDir * PT_SIZE), head.getY() + (yDir * PT_SIZE));
		
		//Use loop to update remaining points
		//Starting from the back we wish to update the points so that they become the points in
		//front of them
		for(int i = snakeList.size()-1; i >= 1; i-- )
		{
			snakeList.set(i, snakeList.get(i-1));
		}
		
		snakeList.set(0, newHead);
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
}
