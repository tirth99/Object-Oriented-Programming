import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class Hw2P2 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
		DataModel dataModel = new DataModel();
		GraphView graph = new GraphView(dataModel);
		TextView text = new TextView(dataModel);
		dataModel.addObserver(graph);
		dataModel.addObserver(text);
		JFrame textFrame = new JFrame();
		JFrame graphFrame = new JFrame();
		String tmpValue;

		while((tmpValue = reader.readLine()) != null) {
			int data = Integer.parseInt(tmpValue.trim());
			dataModel.addData(data);
			JTextField txtField = new JTextField();
			txtField.setText(tmpValue);
			txtField.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {

					try {
						int height = txtField.getHeight();
						int y = txtField.getY();
						int index = y / height;
						if (e.getLength() != 0) {
							String tmp = txtField.getText();
							dataModel.replaceData(index, Integer.parseInt(tmp));
						} else {
							dataModel.replaceData(index, 0);
						}
					}catch(ArithmeticException | IllegalArgumentException ignored) {}
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					try {
						int height = txtField.getHeight();
						int y = txtField.getY();
						int index = y / height;
						if(e.getLength() != 0) {
							String tmp = txtField.getText();
							dataModel.replaceData(index, Integer.parseInt(tmp));
						}
						else {
							dataModel.replaceData(index, 0);
						}
					} catch (ArithmeticException | IllegalArgumentException ignored) {}
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					try {
						int height = txtField.getHeight();
						int y = txtField.getY();
						int index = y / height;
						String tmp = txtField.getText();
						dataModel.replaceData(index, Integer.parseInt(tmp));
					} catch (ArithmeticException | IllegalArgumentException ignored) {}
				}
			});
			text.add(txtField);
		}
		reader.close();

		graph.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int value = e.getX();
				int y = e.getY();
				int height = graph.getIndividualHeight();
				int index = y/height;
				dataModel.replaceData(index, value);
			}
		});
		textFrame.setContentPane(text);
		textFrame.pack();
		textFrame.setVisible(true);

		textFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Text Frame has updated args[0]");
				ArrayList<Integer> textList = dataModel.getDataList();
				try {
					PrintWriter pw = new PrintWriter(new FileWriter("graphs.txt", false));
					for (Integer integer : textList) {
						pw.println(integer);
					}
					pw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		graphFrame.setContentPane(graph);
		graphFrame.setBounds(200, 0, 0, graph.frameHeight());
		graphFrame.setVisible(true);

		graphFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Graph frame has updated args[0]");
				ArrayList<Integer> graphList = dataModel.getDataList();
				try {
					PrintWriter pw = new PrintWriter(new FileWriter("graphs.txt", false));
					for (Integer integer : graphList) {
						pw.println(integer);
					}
					pw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
