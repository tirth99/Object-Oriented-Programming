import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

public class ActionTester
{
	private static int helloCounter = 0;
	private static int goodbyeCounter = 0;
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		final int FIELD_WIDTH = 20;
		JTextField textField = new JTextField(FIELD_WIDTH);
		textField.setText("Click a button!");

		JButton helloButton = new JButton("Say Hello");
		helloButton.setEnabled(true);
		JButton goodbyeButton = new JButton("Say Goodbye");
		goodbyeButton.setEnabled(false);

		helloButton.addActionListener(event -> {
			helloCounter++;
			textField.setText("Hello, World! " + helloCounter);
			goodbyeButton.setEnabled(true);
			helloButton.setEnabled(false);
		});

		goodbyeButton.addActionListener(event -> {
			goodbyeCounter++;
			textField.setText("Goodbye, World! " + goodbyeCounter);
			goodbyeButton.setEnabled(false);
			helloButton.setEnabled(true);
		});
		frame.setLayout(new FlowLayout());

		frame.add(helloButton);
		frame.add(goodbyeButton);
		frame.add(textField);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}