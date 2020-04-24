import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TextView extends Box implements Observer
{
	public TextView(DataModel aModel)
	{
		super(BoxLayout.Y_AXIS);
		this.dataModel = aModel;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(dataModel.getSize() <= this.getComponentCount()) {
			for(Component c : this.getComponents()) {
				JTextField field = (JTextField) c;
				int y = field.getY();
				int height = field.getHeight();
				int index = y / height;
				int fieldValue = Integer.parseInt(field.getText());
				int modelValue = dataModel.getData(index);
				if(fieldValue != modelValue) {
					field.setText(Integer.toString(modelValue));
				}
			}
		}
	}

	private DataModel dataModel;
}