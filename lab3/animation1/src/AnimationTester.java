import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 This program implements an animation that moves
 a car shape.
 */
public class AnimationTester
{
	public static void main(String[] args)
	{
		ArrayList<MoveableShape> objects = new ArrayList<>();
		JFrame frame = new JFrame();

		MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
		MoveableShape shape1 = new CarShape(0, 50,  CAR_WIDTH);
		objects.add(shape);
		objects.add(shape1);

		ShapeIcon icon = new ShapeIcon(objects, ICON_WIDTH, ICON_HEIGHT);

		JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		final int DELAY = 50;
		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, event ->
		{
			for(MoveableShape shapes : objects) {
				shapes.move();
				label.repaint();
			}
		});
		t.start();
	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
}
