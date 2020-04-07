import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Function {

	Function(){

		JFrame frame = new JFrame("Lab 5");
		JButton add = new JButton("add");
		add.setBounds(0,0,250,30);
		frame.add(add);

		JTextField textField = new JTextField();
		textField.setBounds(0,325,250,30);
		frame.add(textField);
		JTextArea area = new JTextArea();
		area.setBounds(0,32,250,290);
		frame.add(area);
		frame.setSize(250,400);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Update(area,textField);
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}