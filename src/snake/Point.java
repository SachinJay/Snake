package snake;
/**
 * Represents a simple 2D point with x and y coordinates  
 */
public class Point
{
	/** x coordinate*/
	private Integer x;
	
	/** y coordinate*/
	private Integer y;
	
	/**Default point at the origin*/
	public Point()
	{
		setX(0);
		setY(0); 
	}
	
	/**Custom constructor for any */
	public Point(Integer x, Integer y)
	{
		this.setX(x); 
		this.setY(y);
	}

	/**
	 * @return the y coordinate
	 */
	public Integer getY()
	{
		return y;
	}

	/**
	 * @param y the y coordinate we want to set
	 */
	public void setY(Integer y)
	{
		this.y = y;
	}

	/**
	 * @return the x coordinate
	 */
	public Integer getX()
	{
		return x;
	}

	/**
	 * @param x the x coordinate we want to set
	 */
	public void setX(Integer x)
	{
		this.x = x;
	}
	
	

}
