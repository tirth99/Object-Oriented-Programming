import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraphView extends JPanel implements Observer {
	public GraphView(DataModel graph) {
		super();
		this.dataModel = graph;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < dataModel.getSize(); i++) {
			Rectangle rect = new Rectangle(0, HEIGHT * i, dataModel.getData(i), HEIGHT);
			g2.draw(rect);
		}
	}

	public int getIndividualHeight() {
		return HEIGHT;
	}

	public int frameHeight() {
		return (HEIGHT * dataModel.getSize()) + 50;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}

	private DataModel dataModel;
	private static final int HEIGHT = 20;
}