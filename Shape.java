import java.awt.Color;
import java.awt.Point;

public class Shape{
	
	protected int xPos;
	protected int yPos;
	protected int Height;
	protected int Width;
	protected Color Color;
	
	/**
	 * 
	 * @param xPos is an integer of the x position.
	 * @param yPos is an integer of the y position.
	 * @param newWidth is an integer of the width.
	 * @param newHeight is an integer of the height.
	 * @param newColor is the color of the shape. 
	 */
	public Shape(int xPos, int yPos, int newWidth, int newHeight, Color newColor) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.Width = newWidth;
		this.Height = newHeight;
		this.Color = newColor;
	}
	
	/**
	 * 
	 * @param other is a shape passed to the constructor. 
	 */
	public Shape(Shape other) {
		this(other.xPos,other.yPos, other.Width,other.Height, other.Color);
	}

	/**
	 * 
	 * @return an integer of the x position. 
	 */
	public int getXPosition() {
		return xPos;
	}
	
	/**
	 * 
	 * @return an integer of the y position.
	 */
	public int getYPosition() {
		return yPos;
	}
	
	/**
	 * 
	 * @return an integer of the width of the shape.
	 */
	public int getWidth() {
		return Width;
	}
	
	/**
	 * 
	 * @return an integer of the height of the shape.
	 */
	public int getHeight() {
		return Height;
	}
	
	/**
	 * Set's the x position of the shape.
	 * @param x passes the x position as an integer.
	 */
	public void setXPosition(int x) {
		xPos = x;
	}
	
	/**
	 * Set's the y position of the shape
	 * @param x passes the y position as an integer.
	 */
	public void setYPosition(int x) {
		yPos = x;
	}
	
	/**
	 * Set's the width of the shape
	 * @param x passes the width as an integer. 
	 */
	public void setWidth(int x) {
		Width = x;
	}
	
	/**
	 * Set's the height of the shape
	 * @param x passes the height as an integer.
	 */
	public void setHeight(int x) {
		Height = x;
	}
	
	/**
	 * 
	 * @return the color of the shape
	 */
	public Color getColor() {
		return Color;
	}
	
	/**
	 * Set's the color of the shape
	 * @param x passes a color to the method
	 */
	public void setColor(Color x) {
		Color = x;
		
	}
	
	/**
	 * 
	 * @param maxX set's the max x position of the box
	 * @param maxY set's the max y position of the box
	 * @return either true or false depending on if the shape is inside or outside the box. 
	 */
	public boolean isInsideBox(int maxX, int maxY) {
		if(yPos + Height <= maxY && xPos + Width <= maxX) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return null because specified further in the child classes. 
	 */
	public Point [] getVertices() {
		return null;
	}
	
	/**
	 * 
	 * @return null because specified further in the child classes. 
	 */
	public double getArea() {
		return 0;
	}
	
	/**
	 * 
	 * @return null because specified further in the child classes. 
	 */
	public double getPerimeter() {
		return 0;
	}
	 
	
	// area and perimiter in ShapeDisplay, and drawRandomGrid in DrawShape 
	
}
