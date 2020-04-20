import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * An icon that is composed of several individual icons.
 */
public class CompositeIcon implements Icon {
	public CompositeIcon() {
		iconList = new ArrayList<>();
	}

	public void addIcon(Icon icon) {
		iconList.add(icon);
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		for (Icon icon : iconList) {
			icon.paintIcon(c, g, x, y);
		}
	}

	public int getIconHeight() {
		for (Icon icon : iconList) {
			if (height < icon.getIconHeight()) {
				height = icon.getIconHeight();
			}
		}
		return height;
	}

	public int getIconWidth() {
		for (Icon icon : iconList) {
			if (width < icon.getIconWidth()) {
				width = icon.getIconWidth();
			}
		}
		return width;
	}

	private int width;
	private int height;
	private ArrayList<Icon> iconList;
}