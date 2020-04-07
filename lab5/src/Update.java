import javax.swing.*;

class Update {
	Update(JTextArea area, JTextField textField){
		area.setText(area.getText()+textField.getText()+"\n");
		textField.setText("");
	}
}
