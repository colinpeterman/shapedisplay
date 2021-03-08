import java.awt.Color;
import java.awt.Point;

public class Octagon extends Shape {

	/**
	 * 
	 * @param xPos is an integer of the x position.
	 * @param yPos is an integer of the y position.
	 * @param newWidth is an integer of the width.
	 * @param newHeight is an integer of the height.
	 * @param newColor is the color of the shape. 
	 */
	public Octagon(int xPos, int yPos, int newWidth, int newHeight, Color newColor) {
		super(xPos, yPos, newWidth, newHeight, newColor);
	}
	
	/**
	 * 
	 * @param other is a Octagon passed to create a constructor
	 */
	public Octagon(Octagon other) {
		super(other);
	}
	
	/**
	 * @param other is an Object that is passed to see if the same one is already printed.
	 * @return true or false depending on whether the shape is the same as another one.
	 */
	public boolean equals(Object other) {
		if(other instanceof Octagon) {
			Octagon T = (Octagon) other;
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
	 * @return the area of the Octagon as an double
	 */
	public double getArea() {
		double a = 0;
		a = (this.getHeight() * this.getWidth());
		double c = ((double) this.getWidth() / 3);
		double d = ((double) this.getHeight() / 3);
		double b = (2 * c * d);
		double area = (a-b);
		area = Math.round(area * 1000.0)/1000.0;
		return area;
	}
	
	/**
	 * 
	 * @return the perimeter of the Octagon as a double
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
		Point[] triangle = new Point[8];
		for(int i = 0; i < triangle.length; i++) {
		    triangle[i] = new Point();
		}
		
		triangle[0].x = (this.getXPosition() + (this.getWidth() / 3));
		triangle[0].y = this.getYPosition();
		
		triangle[1].x = this.getXPosition() + ((2 * this.getWidth()) / 3);
		triangle[1].y = this.getYPosition();
		
		triangle[2].x = this.getXPosition() + this.getWidth();
		triangle[2].y = (this.getYPosition() + (this.getHeight() / 3));
	
		
		triangle[3].x = this.getXPosition() + this.getWidth();
		triangle[3].y = (this.getYPosition() + (2 * this.getHeight() / 3));
		
		triangle[4].x = (this.getXPosition() + (2 * this.getWidth() / 3));
		triangle[4].y = this.getYPosition() + this.getHeight();
		
		triangle[5].x = this.getXPosition() + (this.getWidth() / 3);
		triangle[5].y = this.getYPosition() + this.getHeight();
		
		triangle[6].x = this.getXPosition();
		triangle[6].y = (this.getYPosition() + (2 * this.getHeight() / 3));
		
		triangle[7].x = this.getXPosition();
		triangle[7].y = (this.getYPosition() + (this.getHeight() / 3));
		
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