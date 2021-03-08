import java.awt.Color;
import java.awt.Point;

public class Rectangle extends Shape {
	
	/**
	 * 
	 * @param xPos is an integer of the x position.
	 * @param yPos is an integer of the y position.
	 * @param newWidth is an integer of the width.
	 * @param newHeight is an integer of the height.
	 * @param newColor is the color of the shape. 
	 */
	public Rectangle(int xPos, int yPos, int newWidth, int newHeight, Color newColor) {
		super(xPos, yPos, newWidth, newHeight, newColor);
	}
	
	/**
	 * 
	 * @param other is a Rectangle passed to create a constructor
	 */
	public Rectangle(Rectangle other) {
		super(other);
	}
	
	/**
	 * @param other is an Object that is passed to see if the same one is already printed.
	 * @return true or false depending on whether the shape is the same as another one.
	 */
	public boolean equals(Object other) {
		if(other instanceof Rectangle) {
			Rectangle T = (Rectangle) other;
			if(this.getHeight() == T.getHeight() && this.getWidth() == T.getWidth() && this.getXPosition() == T.getXPosition() && this.getYPosition() == T.getYPosition()) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return the area of the Rectangle as an double
	 */
	public double getArea() {
		double area = (this.getWidth() * this.getHeight());
		area = Math.round(area * 1000.0)/1000.0;
		return area;
	}
	
	/**
	 * 
	 * @return the perimeter of the Rectangle as a double
	 */
	public double getPerimeter() {
		Point[] triangle = this.getVertices();
		double p = 0;
		for(int i = 0; i < triangle.length - 1; i++) {
			p += Math.sqrt(((triangle[i].x - triangle[i+1].x) * (triangle[i].x - triangle[i+1].x)) + ((triangle[i].y - triangle[i+1].y) * (triangle[i].y - triangle[i+1].y)));
		}
		p += Math.sqrt(((triangle[0].x - triangle[triangle.length - 1].x) * (triangle[0].x - triangle[triangle.length - 1].x)) + ((triangle[0].y - triangle[triangle.length - 1].y) * (triangle[0].y - triangle[triangle.length - 1].y)));
		p = Math.round(p * 1000.0)/1000.0;
		return p;
	}
	
	/**
	 * @return an array of point's which are all the vertices.
	 */
	public Point [] getVertices() {
		Point[] triangle = new Point[4];
		for(int i = 0; i < triangle.length; i++) {
		    triangle[i] = new Point();
		}
		triangle[0].x = this.getXPosition();
		triangle[0].y = this.getYPosition();
		triangle[1].x = this.getXPosition() + this.getWidth();
		triangle[1].y = this.getYPosition();
		triangle[3].x = this.getXPosition(); 
		triangle[3].y = this.getHeight() + this.getYPosition();
		triangle[2].x = this.getXPosition() + this.getWidth();
		triangle[2].y = this.getHeight() + this.getYPosition();
		return triangle;	
	}
	
	/**
	 * @return a string to override the toString method.
	 */
	public String toString() {
		String idk = "";
		idk += this.getClass() + " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter();
		return idk;
	}
}
