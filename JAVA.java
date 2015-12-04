import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;


public class JAVA{
	public static void main (String[] args) {
		try{

					FileInputStream fstream= new FileInputStream("m.txt");//specify document name
					DataInputStream in= new DataInputStream(fstream);
					BufferedReader br=new BufferedReader(new InputStreamReader(in), StandardCharsets.UTF_8);
					String line;
					while((line=br.readLine())!= null){
							System.out.println(br.readLine());

					}
					in.close();
					System.out.println("Reading in done!!");

				}
				catch(Exception ex){
					System.out.println("An exception is caught!! ");
					ex.printStackTrace();
		}

	}
}
