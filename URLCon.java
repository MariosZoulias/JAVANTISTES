/**
*Dimiourgia txt me ton kodika html mias selidas
*Na bazete ollo to url ekei pou to zitaei "https://www.google.gr/"
*
*@author Karagiannakis kon., Mpatris St., Kokkinoplitis Nik., Fragkakis Pan.
*@Version 1.0
*@8/12/2015
*/

import java.net.*;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;



public class HtmlTxt {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

		String encoding = "UTF-8"; // Or "ISO-8859-7"



		String string_url;
        System.out.println("enter the website: ");
        string_url = input.next();

		URL a = new URL("http://"+string_url);
		URLConnection y_c = a.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
                                    y_c.getInputStream(),encoding));

		try{
			File file = new File("C:/Users/stamatis/Desktop/html.txt");

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