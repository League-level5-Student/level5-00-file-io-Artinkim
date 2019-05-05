package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {

			FileReader fr;
			try {
				fr = new FileReader("message.txt");
				int c = fr.read();
				String s = "";
				while(c != -1) {
					 s += fr.read();
					 c = fr.read();
				}
				fr.close();
				String ns = "";
				for(int i = 0;i<s.length();i++) {
					ns += (char) (s.charAt(i) + 1200);
				}
				JOptionPane.showMessageDialog(null, ns);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		
	}
	
}
