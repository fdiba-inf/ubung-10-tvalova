package exercise10;
import java.lang.Math;

public class Ellipse extends Figure{

    public Ellipse() {
      super(new Point (0, 0), 1, 1);
    }
  
    public Ellipse(Point startPoint, double a, double b) {
      super(startPoint, a, b);
    }

    public Ellipse(Ellipse otherEllipse) {
      super(otherEllipse.startPoint, otherEllipse.side1, otherEllipse.side2);
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side1 + side2) - Math.sqrt((3.0 * side1 + side2) * (side1 + 3.0 * side2)));
    }

    @Override
    public double calculateArea() {
        return Math.PI * side1 * side2;
    }

    @Override
    public String getType() {
        return (side1 == side2) ? "Circle" : "Ellipse";
    }

    public boolean equal(Figure aFigure) {
        boolean sameA = Utils.equals(side1, aFigure.side1);
        boolean sameB = Utils.equals(side2, aFigure.side2);
        boolean sameAReversed = Utils.equals(side1, aFigure.side1);
        boolean sameBReversed = Utils.equals(side2, aFigure.side2);

        return (sameA && sameB) || (sameAReversed && sameBReversed);
    }

    public boolean containsClick(Point click) {
        // Check if click point is inside the rectangle
        Point center = new Point();
        center = startPoint.createNewTranslatedPoint(side1, side2);
        if (Math.pow(click.getX() - center.getX(), 2) / Math.pow(side1, 2) + Math.pow(click.getY() - center.getY(), 2) / Math.pow(side2, 2) <= 1){
          return true;
        } else
        return false;
    }
}
