package snake;

import java.awt.Color;

public class Constants
{
	//Size of the applet
	public static final Integer WIDTH = 500;
	public static final Integer HEIGHT = 500;
	
	//Number of squares that make up the snake when the game starts
	public static final Integer INIT_SNAKE_SIZE = 25;
	
	//Size of square food
	public static final Integer FOOD_SIZE = 10;
	
	//Start coordinates of the snake's head
	public static final Integer START_X = 160;
	public static final Integer START_Y = 160;
	
	//Directions
	public static final Integer UP = -1; 
	public static final Integer DOWN = 1; 
	public static final Integer LEFT = -1;
	public static final Integer RIGHT = 1;
	
	//Size of each square of the snake
	public static final Integer PT_SIZE = 5;
	
	//Colors
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color END_COLOR = Color.RED;
	public static final Color[] FOOD_COLORS = {Color.green, Color.CYAN, Color.RED, Color.ORANGE, Color.MAGENTA};
	public static final Integer NUM_FOOD_COLORS = FOOD_COLORS.length;
	
	//Time between frames of the image (in milliseconds)
	public static final Long SLEEP_TIME = (long) 50;
	
	//Margin between the game over line and the score line
	public static final Integer MARGIN = 20;
}
