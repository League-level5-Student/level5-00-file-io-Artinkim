package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		try {
		FileWriter fw = new FileWriter("src/_01_File_Recorder/Cool.txt",true);
		String s = JOptionPane.showInputDialog("Write to the file");
		fw.write("\n"+ s);
		fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
