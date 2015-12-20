import java.net.*;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;



public class URLCon {
	public URLCon() {};
    public void createTxt(String string_url) throws Exception {

	String encoding = "UTF-8"; // Or "ISO-8859-7".h entolh tha xrhsimopoihthei gia thn emfanish twn ellinikwn

	String str = string_url;


	URL a = new URL("http://"+string_url);
	URLConnection y_c = a.openConnection();
	BufferedReader in = new BufferedReader(new InputStreamReader( y_c.getInputStream(),encoding)); //To encoding einai gia ta ellinika

       	try{
		File file = new File("html.txt"); //to arxeio ftiaxnetai ston idio fakelo me tis klasseis

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sb = new StringBuffer();
		String line = null;

		String inputLine;
		while ((inputLine = in.readLine()) != null){

			bw.write(inputLine);
            		bw.newLine();
            		sb.append(line);

		}
		bw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
		in.close();

    }
}
