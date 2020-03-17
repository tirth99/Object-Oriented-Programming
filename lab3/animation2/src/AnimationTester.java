import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 This program implements an animation that moves
 a car shape.
 */
public class AnimationTester
{
	static boolean goUp = false;
	static boolean goDown = true;
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		MoveableShape shape = new BouncingBall(0, 0, CAR_WIDTH);

		ShapeIcon icon = new ShapeIcon(shape, 0, 0);

		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		final int DELAY = 10;
		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, event ->
		{
			if(goUp) {
				shape.move(1, -1);
				if(shape.getY() == 0) {
					goDown = true;
					goUp = false;
				}
			}
			else if(goDown){
				shape.move(1, 1);
				if(shape.getY() == 350) {
					goUp = true;
					goDown = false;
				}
				if(shape.getX() == 1000) {
					goDown = false;
					goUp = true;
				}
			}
			label.repaint();
		});
		t.start();
	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
}
