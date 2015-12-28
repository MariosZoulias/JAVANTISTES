import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

public class DoubleSearch {
	public static void main(String args[]) {
		String pass = "<h1>Εργασία στην <strong>Java</strong></h1>";
		char[] passInCharArray = pass.toCharArray();
		for (char temp : passInCharArray) {
			System.out.println(temp);
		}
		char key = '>';
		int closing = 0;
		int close = 0;
		int p = 0;
		int s = 0;
		int returnvalue = -1;
		for (int i = 0; i < passInCharArray.length; i++) {
			if (key == passInCharArray[i]) {
				p = p + 1;
				if (p == 1) {
					returnvalue = i;
				} else if (p == 2) {
				      closing = i;
			    } else if (p == 3) {
				  	s = i;
				  	break;
				}
			}
    	}
		System.out.println("Key was found in" + returnvalue );
		System.out.println("Key was found in" + closing );
		System.out.println("Key was found in" + s );
		char lastKey = '<';
		int value = 0;
		int k = 0;
		int last = 0;
		int inside = 0;
		for (int i = 0; i < passInCharArray.length; i++) {
			if (lastKey == passInCharArray[i]) {
				k = k + 1;
		    	if (k == 1) {
					System.out.println("First char");
				} else if (k == 2) {
					value = i;
				} else if (k == 3) {
					inside = i;
				} else if (k == 4) {
					last = i;
				}
			}
    	}
    	System.out.println("Key was found in" + value);
    	System.out.println("Tag was found in" + inside);
    	System.out.println("Key was found in" + last );
    	for (int i = value; i <= closing; i++) {
			passInCharArray = ArrayUtils.remove(passInCharArray, i);
		}
		int a = 0;
				for (int i = 0; i < passInCharArray.length; i++) {
					if (key == passInCharArray[i]) {
						a = a + 1;
						if (a == 1) {
							returnvalue = i;
						} else if (a == 2) {
						      closing = i;
					    } else if (a == 3) {
						  	s = i;
						  	break;
						}
					}
		    	}
				System.out.println("Key was found in" + returnvalue );
				System.out.println("Key was found in" + closing );
				System.out.println("Key was found in" + s );
				int q = 0;
				for (int i = 0; i < passInCharArray.length; i++) {
					if (lastKey == passInCharArray[i]) {
						q = q + 1;
				    	if (q == 1) {
							System.out.println("First char");
						} else if (q == 2) {
							value = i;
						} else if (q == 3) {
							inside = i;
						} else if (q == 4) {
							last = i;
						}
					}
		    	}
		    	System.out.println("Key was found in" + value);
		    	System.out.println("Tag was found in" + inside);
    	System.out.println("Key was found in" + last );
		for (int i = inside; i <= s; i++) {
			passInCharArray = ArrayUtils.remove(passInCharArray, i);
		}
		for (char temp : passInCharArray) {
					System.out.println(temp);
				}
				int r = 0;
				for (int i = 0; i < passInCharArray.length; i++) {
					if (key == passInCharArray[i]) {
						r = r + 1;
						if (r == 1) {
							returnvalue = i;
						} else if (r == 2) {
						      closing = i;
					    } else if (r == 3) {
						  	s = i;
						  	break;
						}
					}
		    	}
				System.out.println("Key was found in" + returnvalue );
				System.out.println("Key was found in" + closing );
				System.out.println("Key was found in" + s );
				int l = 0;
				for (int i = 0; i < passInCharArray.length; i++) {
					if (lastKey == passInCharArray[i]) {
						l = l + 1;
				    	if (l == 1) {
							System.out.println("First char");
						} else if (l == 2) {
							value = i;
						} else if (l == 3) {
							inside = i;
						} else if (l == 4) {
							last = i;
						}
					}
		    	}
		    	System.out.println("Key was found in" + value);
		    	System.out.println("Tag was found in" + inside);
    	System.out.println("Key was found in" + last );
    	char htmlCommand[];
    	int fields = ((last - returnvalue) - 1);
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
