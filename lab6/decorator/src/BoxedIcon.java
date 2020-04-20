import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

/**
 * Displays Boxed MarsIcon
 */
public class BoxedIcon implements Icon
{
	public BoxedIcon(Icon marsIcon) {
		icon = marsIcon;
	}

	public int getIconWidth() {
		return icon.getIconWidth() + PIXEL_GAP * 2;
	}

	public int getIconHeight() {
		return icon.getIconHeight() + PIXEL_GAP * 2;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {

		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Rectangle2D.Double(x, y,
				getIconWidth() - 1, getIconHeight() - 1));
		icon.paintIcon(c, g, x + PIXEL_GAP, y + PIXEL_GAP);
	}

	private static final int PIXEL_GAP = 10;
	private Icon icon;
}