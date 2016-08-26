package ex3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Filewriter {

	public void write(String data) throws IOException{
		FileWriter writer = new FileWriter("C:/Users/TimmosQuadros/Desktop/backup.txt", false);
		PrintWriter out = new PrintWriter(writer);
		out.println(/*"This is written to the file"*/data);
		out.close(); 
	}

}
