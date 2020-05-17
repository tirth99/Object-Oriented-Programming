import javax.swing.*;

/**
 * This class is used to animate a car using thread and implements Runnable class.
 */
public class CarAnimator implements Runnable{
	private int timeDelay;
	private MoveableShape carShape;
	private JLabel label;

	public CarAnimator(int delay, MoveableShape shape, JLabel label) {
		this.timeDelay = delay;
		this.carShape = shape;
		this.label = label;
	}
	public void run() {
		try {
			do {
				carShape.move();
				label.repaint();
				Thread.sleep(timeDelay);
			} while (true);
		}
		catch (InterruptedException ignored) {
		}
	}
}