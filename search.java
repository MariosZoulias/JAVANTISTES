import java.util.ArrayList;
import java.util.Arrays;

public class Search {
	public static void main(String args[]) {
		String pass = "<h1>βιογραφικοοoooooo</h1>";
		char[] passInCharArray = pass.toCharArray();
		for (char temp : passInCharArray) {
			System.out.println(temp);
		}
		char key = '>';
		int returnvalue = -1;
		for (int i = 0; i < passInCharArray.length; i++) {
			if (key == passInCharArray[i]) {
				returnvalue = i;
				break;
			}
    	}
		System.out.println("Key was found in" + returnvalue );
		char lastKey = '<';
		int value = -1;
		int index = -1;
		for (int i = 0; i < passInCharArray.length; i++) {
			if (lastKey == passInCharArray[i]) {
		    	value = i;
		    	if (value > 1) {
					index = i;
				}
		    }
    	}
    	System.out.println("Key was found in" + index);
    	char htmlCommand[];
    	int fields = ((index - returnvalue) - 1);
    	htmlCommand = new char[fields];
    	int sum = returnvalue + 1;
		for (int j = 0; j < fields; j++) {
			htmlCommand[j] = passInCharArray[sum + j];
		}
		for (char temp : htmlCommand) {
			System.out.println(temp);
		}
		String command = String.valueOf(htmlCommand);
		System.out.printf("%s\n", command);
	}
}
