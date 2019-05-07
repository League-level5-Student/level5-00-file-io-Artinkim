package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame window = new JFrame("To do list");
	JButton b1 = new JButton("add task");
	JButton b2 = new JButton("view tasks");
	JButton b3 = new JButton("remove task");
	JButton b4 = new JButton("save list");
	JButton b5 = new JButton("load list");
	JPanel panel = new JPanel();
	ArrayList<String> list = new ArrayList<String>();
	public ToDoList() {
		window.setVisible(true);
		window.add(panel);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		window.pack();	
		
	}
	public static void main(String[] args) {
		ToDoList td = new ToDoList();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		if(b.equals(b1)) {
			String s = JOptionPane.showInputDialog("Enter Task");
			list.add(s);
		} 
		if(b.equals(b2)) {
			for(String s:list) {
				System.out.println(s);
			}
		}
		if(b.equals(b3)) {
			String s = JOptionPane.showInputDialog("Which task do you want to remove?");
			list.remove(s);
		}
		if(b.equals(b4)) {
			try {
				FileWriter fr = new FileWriter("ToDoList.txt",true);
				for(String s: list) {
					fr.write(s);
					fr.write("\n");
				}
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(b.equals(b5)) {
			String s = JOptionPane.showInputDialog("Where is the location of the file?");
			try {
				BufferedReader br = new BufferedReader(new FileReader(s));
				String c = br.readLine();
				while(c != null) {
					System.out.println(c);
					c = br.readLine();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
}
