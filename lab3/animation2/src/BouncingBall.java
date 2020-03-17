import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * A bouncing ball that will ricochet around the frame.
 */
public class BouncingBall implements MoveableShape {

	private int x;
	private int y;
	private int width;

	public BouncingBall (int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void move(int ax, int ay) {
		x += ax;
		y += ay;
	}

	public void draw(Graphics2D g) {

		Ellipse2D.Double ball = new Ellipse2D.Double(x, y, width, width);
		g.draw(ball);
		g.setColor(Color.RED);
	}
}
