import java.net.*;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;

public class URLCon {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);


		String string_url;
        System.out.println("enter the website: ");
        string_url = input.next();

		URL a = new URL(string_url);
		URLConnection y_c = a.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
                                    y_c.getInputStream()));

		try{
			File file = new File("C:/Users/User/Desktop/html.txt");

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			String inputLine;
			while ((inputLine = in.readLine()) != null){
            	bw.write(inputLine);
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();


	}
}
