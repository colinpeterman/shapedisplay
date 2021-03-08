import java.awt.Color;
import java.util.Random;

public class DrawShapes {

 public static void main(String[] args) {
  ShapeDisplayer disp = new ShapeDisplayer();
  
  // USE THE CODE BELOW TO HELP YOU WITH TESTING. WHEN YOU ARE FINISHED, YOU WILL DELETE THE CODE BELOW
  // AND JUST CALL THE drawRandomGrid METHOD.
  drawRandomGrid(disp,3,9);
  //drawRandomGrid(disp,2,2);
  //drawRandomGrid(disp,4,8);
  //drawRandomGrid(disp,1,10);
  //drawRandomGrid(disp,100,100);

 }
 
 /*
  * Draws a r by c grid of random shapes.
  */
 public static void drawRandomGrid(ShapeDisplayer disp, int rows, int cols) {
	 
	 
	 for(int i = 0; i < rows; i++) {
		 for(int x = 0; x < cols; x ++) {
			 Random rand = new Random(); 
			 int value = rand.nextInt(4 + 1);
			 int r = rand.nextInt(255 + 1);
			 int g = rand.nextInt(255 + 1);
			 int b = rand.nextInt(255 + 1);
			 Color random = new Color(r,g,b);
			 if (value == 0) {
				 disp.addShape(new Triangle(( x * (300 / cols)),(i * (300 / rows)) , (300 / cols), (300 / rows), random));
			 }
			 else if(value == 1) {
				 disp.addShape(new Rectangle((x * (300 / cols)),(i * (300 / rows)) , (300 / cols), (300 / rows), random));
			 }
			 else if(value == 2) {
				 disp.addShape(new Pentagon((x * (300 / cols)),(i  * (300 / rows)) , (300 / cols), (300 / rows), random));
			 }
			 else if(value == 3) {
				 disp.addShape(new Hexagon((x * (300 / cols)),(i * (300 / rows)) , (300 / cols), (300 / rows), random));
			 }
			 else {
				 disp.addShape(new Octagon((x * (300 / cols)),(i * (300 / rows)) , (300 / cols), (300 / rows), random));
			 }
		 }
	 }
  
  
  
 }

}
