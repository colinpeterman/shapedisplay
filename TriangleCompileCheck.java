import java.awt.Color;
import java.awt.Point;

public class TriangleCompileCheck {

 public static void main(String[] args) {
  Triangle t = new Triangle(10, 10, 10, 10, new Color(255, 0, 0));
  t.setColor(new Color(0, 0, 255));
  t.setHeight(20);
  t.setWidth(20);
  t.setXPosition(20);
  t.setYPosition(20);
  Color s = t.getColor();
  int i = t.getHeight();
  i = t.getWidth();
  i = t.getXPosition();
  i = t.getYPosition();
  Point[] ps = t.getVertices();
  boolean b = t.equals(t);
  b = t.isInsideBox(400, 400);
  Triangle t2 = new Triangle(t);
  double x = t.getArea();
  x = t.getPerimeter(); 
 }

}
