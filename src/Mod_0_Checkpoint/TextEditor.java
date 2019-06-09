package Mod_0_Checkpoint;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor {
	JFrame window;
	JPanel panel;
	JButton saveButton;
	JButton loadButton;
	JTextArea textArea;
	public static void main(String[] args) {
		new TextEditor().start();
	}
	void start() {
		window = new JFrame();
		panel = new JPanel();
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		textArea = new JTextArea(50,50);
		window.add(panel);
		window.setPreferredSize(new Dimension(500,500));
		panel.add(saveButton);
		panel.add(loadButton);
		saveButton.addActionListener((e)-> {
			String s = JOptionPane.showInputDialog("Where do you want the file to be stored");
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(s)));
				oos.writeObject(textArea);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		loadButton.addActionListener((e)-> {
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			String file = "";
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile().getAbsolutePath();
			}
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(file)));
				panel.remove(textArea);
				textArea = (JTextArea) ois.readObject();
				panel.add(textArea);
				window.pack();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		panel.add(textArea);
		window.setVisible(true);
		window.pack();
	}
}
