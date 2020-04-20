import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 Class for complex for the three required complex shapes.
 */
public class CompositeShape implements Shape
{
	public CompositeShape() {
		requiredShapes = new ArrayList<>();
	}

	public void add(Shape aShape) {
		requiredShapes.add(aShape);
	}

	public boolean contains(double x, double y, double w, double h) {
		for (Shape s : requiredShapes) {
			if (s.contains(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}


	public boolean contains(Point2D p) {
		for (Shape s : requiredShapes) {
			if (s.contains(p)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(double x, double y) {
		for (Shape s : requiredShapes) {
			if (s.contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(Rectangle2D rect) {
		for (Shape s : requiredShapes) {
			if (s.contains(rect)) {
				return true;
			}
		}
		return false;
	}

	public PathIterator getPathIterator(AffineTransform transform) {
		HelperPathIterator iterator = new HelperPathIterator();
		for (Shape shape : requiredShapes) {
			iterator.add(shape.getPathIterator(transform));
		}
		return iterator;
	}

	public PathIterator getPathIterator(AffineTransform transform, double v) {
		HelperPathIterator iterator = new HelperPathIterator();
		for (Shape shape : requiredShapes) {
			iterator.add(shape.getPathIterator(transform, v));
		}
		return iterator;
	}

	public Rectangle getBounds() {
		if (requiredShapes.size() == 0) {
			return new Rectangle();
		}
		Shape shape = requiredShapes.get(0);
		Rectangle rect = shape.getBounds();
		for (int i = 1; i < requiredShapes.size(); i++)
		{
			shape = requiredShapes.get(i);
			rect = rect.union(shape.getBounds());
		}
		return rect;
	}

	public Rectangle2D getBounds2D() {
		if (requiredShapes.size() == 0) {
			return new Rectangle2D.Double();
		}
		Shape shape = requiredShapes.get(0);
		Rectangle2D rect = shape.getBounds2D();
		for (int i = 1; i < requiredShapes.size(); i++) {
			shape = requiredShapes.get(i);
			Rectangle2D.union(rect, shape.getBounds(), rect);
		}
		return rect;
	}

	public boolean intersects(Rectangle2D rect) {
		for (Shape shape : requiredShapes) {
			if (shape.intersects(rect)) {
				return true;
			}
		}
		return false;
	}

	public boolean intersects(double x, double y, double w, double h) {
		for (Shape shape : requiredShapes) {
			if (shape.intersects(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<Shape> requiredShapes;
}