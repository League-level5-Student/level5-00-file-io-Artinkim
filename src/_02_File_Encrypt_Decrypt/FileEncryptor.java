package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Give me message");
		String es = "";
		for(int i = 0;i<s.length();i++) {
			es += (char) (s.charAt(i) - 1200);
		}
		FileWriter fw;
		try {
			fw = new FileWriter("message.txt");
			fw.write(es);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	
}
