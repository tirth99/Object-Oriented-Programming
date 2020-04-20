import java.awt.geom.PathIterator;
import java.util.ArrayList;

/**
 * A helper path iterator class that calls path iterators of individual objects.
 *
 */
public class HelperPathIterator implements PathIterator {
	public HelperPathIterator() {
		pathIterators = new ArrayList<>();
	}

	public void add(PathIterator pathIterator) {
		pathIterators.add(pathIterator);
	}

	public void next() {
		PathIterator currentIterator = pathIterators.get(currentShape);
		if (currentIterator.isDone()) {
			currentShape++;
			pathIterators.get(currentShape).next();
		} else {
			currentIterator.next();
		}
	}

	public int currentSegment(float[] coords) {
		PathIterator currentIterator = pathIterators.get(currentShape);
		if (currentIterator.isDone()) {
			currentShape++;
			return pathIterators.get(currentShape).currentSegment(coords);
		}
		else {
			return currentIterator.currentSegment(coords);
		}
	}

	public int getWindingRule() {
		return pathIterators.get(currentShape).getWindingRule();
	}

	public boolean isDone() {
		return pathIterators.size() == 0 || pathIterators.get(pathIterators.size() - 1).isDone();
	}

	public int currentSegment(double[] coords) {
		PathIterator currentIterator = pathIterators.get(currentShape);
		if (currentIterator.isDone()) {
			currentShape++;
			return pathIterators.get(currentShape).currentSegment(coords);
		}
		else {
			return currentIterator.currentSegment(coords);
		}
	}

	private int currentShape;
	private ArrayList<PathIterator> pathIterators;
}