import java.awt.*;
import javax.swing.*;

/**
 This program implements an animation that moves
 a car shape.
 */
public class AnimationTester {
	private static final int TOTAL_CARS = 4;
	private static final int TIME_DELAY = 10;
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Various cars at different speeds");

		for (int i = 1; i <= TOTAL_CARS; i++) {
			MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
			ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);

			JLabel label = new JLabel(icon);
			frame.add(label);

			CarAnimator animator = new CarAnimator(i * TIME_DELAY, shape, label);
			Thread thread = new Thread(animator);
			thread.start();
		}
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 450);
		frame.setVisible(true);
	}
}