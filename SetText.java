import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SetText extends JPanel {
	/** Ta ekana se pinakes gia na mporw na valw for, eksallou einai ki h search vasismenh se pinakes **/
	String[] word = {"Zoulia, Trompa,Xanoumi"};
	/** bold : maurizmena ,mporei na allaksei kai na mpei italic**/
	int[] setStyle = {Font.BOLD};
	public void paint(Graphics graphics) {
		for (int i = 0; i < word.length; i++) {
			for (int j = 0; j < setStyle.length; j++) {
				/** To noumero 30 einai to megethos ths lekshs **/
				Font viewWord = new Font(word[i], setStyle[j], 30);
				/** Kalw to graphiko stoixeio graphics me th methodo set font, pou trompa zoulia einai etoimh me orisma font viewWord stoixeio **/
				graphics.setFont(viewWord);
				String outputWord = word[i];
				/**Deite pws douleyei h drawstring  http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawStringStringstrintxinty.htm**/
				graphics.drawString(outputWord, 50, 50);
				/** Ta 150 einai h thesi ths leksis sto panel **/
			}
		}
	}
	/** Methodos gia anoigma control panel frame pws legetai telos pantwn, o ladopoulos tha to anoiksei me to diko tou **/
	 public static void main(String[] a) {
	         JFrame b = new JFrame();
	         b.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent c) {
	               System.exit(0);
	            }
	         }
	      );
	      /** Kathorismos stoixeiwn gia to panel pou tha anoiksei **/
	      b.setContentPane(new SetText());
	      b.setSize(500,500);
	      b.setVisible(true);
	   }
}
