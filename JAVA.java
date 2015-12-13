import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.*;
import java.io.File;


public class JAVA{
	public static void main (String[] args) {
		String encoding = "UTF-8";
		try{

					FileInputStream fstream= new FileInputStream("m.txt");//specify document name
					DataInputStream in= new DataInputStream(fstream);
					BufferedReader br=new BufferedReader(new InputStreamReader(in , encoding));

					String line;
					while((line=br.readLine())!= null){
						if (line.contains("<h1")){
							/*Αποθηκεύει σε έναν πίνακα όλους τους χαρακτήρες που διαβάζει στη γραμμή*/
								char[] passInCharArray = line.toCharArray();
								char key = '>';
								int returnvalue = -1;
							/*Βρίσκει που κλείνει η εντολή html αρχικά, για να ακολουθήσει το περιεχόμενό της, και επιστρέφει τη θέση του στον πίνακα */
								for (int i = 0; i < passInCharArray.length; i++) {
									if (key == passInCharArray[i]) {
										returnvalue = i;
										break;
									}
						    	}
								char lastKey = '<';
								int value = -1;
								int index = -1;
							/*Εκτελεί ακριβώς την ίδια διαδικασία για τον χαρακτήρα : < */
								for (int i = 0; i < passInCharArray.length; i++) {
									if (lastKey == passInCharArray[i]) {
								    	value = i;
								    	if (value > 1) {
											index = i;
										}
								    }
						    	}
						    	/*Περνάει σε έναν πίνακα χαρακτήρων τα στοιχεία που βρίσκονται μεταξύ των > < */
						    	char htmlCommand[];
						    	int fields = ((index - returnvalue) - 1);
						    	htmlCommand = new char[fields];
						    	int sum = returnvalue + 1;
								for (int j = 0; j < fields; j++) {
									htmlCommand[j] = passInCharArray[sum + j];
								}
							/*Μετατρέπει τον πίνακα χαρακτήρων σε συμβολοσειρά την οποία και εμφανίζει */
								String command = String.valueOf(htmlCommand);
								System.out.println(command.toUpperCase());
						}
					}
					in.close();
					System.out.println("Reading is done!!!!!");

				}
				catch(Exception ex){
					System.out.println("An exception is caught!! ");
					ex.printStackTrace();
		}

	}
}


