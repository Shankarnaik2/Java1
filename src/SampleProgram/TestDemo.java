package SampleProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestDemo {
	public static void main(String[] args) throws IOException {
		int count =0;
	      File file = new File("C:/Users/Shankar/Downloads/ParabluKT(2)");
	      FileInputStream fis = new FileInputStream(file);
	      byte[] bytesArray = new byte[(int)file.length()];
	      fis.read(bytesArray);
	      String s = new String(bytesArray);
	      System.out.println("Contents of the given file are :: " +new String(bytesArray));
	}

}
