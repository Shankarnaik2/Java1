package SampleProgram;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestDemo {
	public static void main(String[] args) throws IOException {
		String strFileDirectoryPath = "C:\\Users\\Shankar\\Downloads\\Parablu KT (2).txt";
		try {
		FileInputStream fstream = new FileInputStream(strFileDirectoryPath);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
	
		while ((strLine = br.readLine()) != null) {
			System.out.println(strLine);
		}
		in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
