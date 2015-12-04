import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class JAVA {

	public static void main(String[] args) {
		try {
			File m = new File("m.txt");
			FileReader bio = new FileReader(m);
			BufferedReader in = new BufferedReader(bio);
			StringBuffer constructLine = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				constructLine.append(line);
				constructLine.append("\n");
			}
			bio.close();
			System.out.println(constructLine.toString());
		} catch (IOException exception) {
		exception.printStackTrace();
		  }
	}
}
