import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

/**
 * A class that draws various shapes. You should NOT modify anything in this
 * file (but feel free to read through the code) . If you think there is a
 * problem with this code, please contact your instructor.
 * 
 * @author DJ Rao, Keith Frikken, Lukasz Opyrchal, Norm Krumpe
 *
 */
public class ShapeDisplayer extends JFrame {

 private static final long serialVersionUID = -2029318760329821513L;
 private JLabel statusLabel;
 private ArrayList<Shape> shapeList = new ArrayList<Shape>();

 public ShapeDisplayer() {
  super("Colin Peterman's Shape Displayer"); // Your name here
  setLayout(new BorderLayout(1, 1));
  setPreferredSize(new Dimension(400, 400));
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  this.setResizable(false);
  // Create a scroll pane to contain the components.
  JScrollPane jsp = new JScrollPane(new Board());
  add(jsp, BorderLayout.CENTER);
  // Create a JLabel to display mouse coordinates.
  statusLabel = new JLabel("BOTTOM STATUS LABEL");
  add(statusLabel, BorderLayout.SOUTH);
  // Pack and show
  pack();
  setVisible(true);
 }

 /**
  * Adds a shape to the ShapeDisplayer. There is a better way to do this, but we
  * need to cover polymorphism and abstract classes first. Shape must be a
  * triangle, rectangle, or star.
  * 
  * @param newShape The shape to add.
  */
 public void addShape(Shape newShape) {
  if (newShape.isInsideBox(350, 350)) {
   
   // the contains() method depends on newShape having a properly defined equals
   // method
   if (!shapeList.contains(newShape)) {
    shapeList.add(newShape);
    System.out.println("ADDED: " + newShape);
   }
   else 
    System.out.println("***DUPLICATE SHAPE: " + newShape);
  }
  else {
   System.out.println("***OUT OF BOUNDS: " + newShape);
  }

  repaint();
 }

 /**
  * A board class that extends JComponent, represents the grid area
  * 
  * @author DJ Rao, Keith Frikken, Norm Krumpe
  *
  */
 private class Board extends JComponent {
  /**
   * To keep eclipse happy.
   */
  private static final long serialVersionUID = -7223666151237066589L;

  /**
   * Sets the preferred size, but it is not explicitly called.
   */
  public Dimension getPreferredSize() {
   Dimension size = new Dimension(200, 200);
   return size;
  }

  /**
   * Paints all shapes in the list.
   */
  public void paintComponent(Graphics g) {
   paintBackground(g);
   // Draw all the shapes.  DO NOT MODIFY THIS LOOP IN ANY WAY
   for (int i = 0; (i < shapeList.size()); i++) {
    Point[] points = new Point[0];
    Shape current = shapeList.get(i);

    points = current.getVertices();

    Color shapeColor = current.getColor();
    Polygon vertices = new Polygon();
    for (Point p : points) {
     vertices.addPoint(p.x, p.y);
    }
    g.setColor(new Color(shapeColor.getRed(), shapeColor.getGreen(), shapeColor.getBlue(), 200));
    g.fillPolygon(vertices);
    g.setColor(shapeColor);
    g.drawPolygon(vertices);
   }
   
   // WRITE CODE HERE TO COMPUTE THE TOTAL AREA AND PERIMETER OF YOUR SHAPES
   double area = 0;
   double perimeter = 0;
   for(Shape num: shapeList) {
	   area += num.getArea();
	   perimeter += num.getPerimeter();
   }
   area = Math.round(area * 1000.0)/1000.0;
   perimeter = Math.round(perimeter * 1000.0)/1000.0;
   
   

   // MODIFY THE NEXT LINE SO THAT IT SHOWS THE SHAPE COUNT, TOTAL AREA, AND TOTAL PERIMETER
   // (DECIMALS ROUNDED TO 3 PLACES)
   statusLabel.setText(shapeList.size() + " shapes displayed" + " Area: " + area + " Perimeter: " + perimeter);
  }

  /**
   * Creates the background. Makes a grey grid and sets the background to black.
   * 
   * @param g A graphic component.
   */
  public void paintBackground(Graphics g) {
   final int width = getWidth();
   final int height = getHeight();
   g.setColor(Color.BLACK);
   g.fillRect(0, 0, getWidth(), getHeight());
   g.setColor(Color.LIGHT_GRAY);
   // Draw horizontal lines and print labels with small font.
   g.setFont(g.getFont().deriveFont(g.getFont().getSize() - 2.0f));
   for (int y = 0; (y < height); y += 50) {
    g.drawLine(0, y, width, y);
    g.drawString("" + y, 0, y - 2);
    g.drawString("" + y, width - 25, y - 2);
   }
   // Draw vertical lines and print labels.
   for (int x = 0; (x < width); x += 50) {
    g.drawLine(x, 0, x, height);
    g.drawString("" + x, x + 1, 10);
    g.drawString("" + x, x + 1, height - 1);
   }
  }
 }

}
