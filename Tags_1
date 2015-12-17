import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.*;
import java.io.File;



public class Tags_1 {
	public static String finder(String line){
		String encoding = "UTF-8";
							/*apo8ikeuei se ena pinaka olous tous xaraktires pou diavazei sth grammi*/
								char[] passInCharArray = line.toCharArray();
								char key = '>';
								int returnvalue = -1;
							/*briskei pou kleinei h entolh html arxika gia na akolou8isei to periexomeno ths, kai epistrefei th 8esh tu sto pinaka */
								for (int i = 0; i < passInCharArray.length; i++) {
									if (key == passInCharArray[i]) {
										returnvalue = i;
										break;
									}
						    	}
								char lastKey = '<';
								int value = -1;
								int index = -1;
							/*ektelei thn idia akrivws diadikasia gia ton xaraktira : < */
								for (int i = 0; i < passInCharArray.length; i++) {
									if (lastKey == passInCharArray[i]) {
								    	value = i;
								    	if (value > 1) {
											index = i;
										}
								    }
						    	}
						    	/*pernaei se enan pinaka xarakthrwn ta stoixeia pou vrisontai metaksu twn > < */
						    	char htmlCommand[];
						    	int fields = ((index - returnvalue) - 1);
						    	htmlCommand = new char[fields];
						    	int sum = returnvalue + 1;
								for (int j = 0; j < fields; j++) {
									htmlCommand[j] = passInCharArray[sum + j];
								}
							/*eatrepei ton pinaka xarakthrwn se sumboloseiragia thn opoia kai emfanizei*/
								String command = String.valueOf(htmlCommand);
								return command;
						}

		public static String p(String line){
			String x = finder(line);
			return x;
		}

}
