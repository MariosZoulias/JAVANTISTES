import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Color;

@SuppressWarnings("serial")
public class WebBrowser extends JFrame implements ActionListener {

	private JPanel middlePanel;
	private JTextField textField;
	@SuppressWarnings("unused")
	private JLabel label;
	private JEditorPane displayEditorPane;

	public static void main(final String[] args) {
		WebBrowser frame = new WebBrowser();
		frame.setTitle("Javantistes Web Browser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 400);
		frame.setVisible(true);
	}

	public WebBrowser() {
		middlePanel = new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    middlePanel.add(label = new JLabel("URL:"));

	    middlePanel.add(textField = new JTextField(40));
	    textField.setToolTipText("Enter URL");
	    getContentPane().add(middlePanel, BorderLayout.NORTH);

	    textField.addActionListener(this);

        displayEditorPane = new JEditorPane();
        displayEditorPane.setContentType("text/html");
        displayEditorPane.setEditable(false);


	    getContentPane().add(displayEditorPane, BorderLayout.CENTER);



	    JScrollPane scrollPane = new JScrollPane(
	    		displayEditorPane); //allagi gia to scrollBar
	    add(scrollPane, BorderLayout.CENTER);

	}


	public final void actionPerformed(final ActionEvent e) {
		String stringUrl = textField.getText();
		URLCon urlcon = new URLCon();
			try {
				urlcon.createTxt(stringUrl);
			} catch (Exception ab) {
				System.out.println("ERROR !");
			}
			try {
				int d1, d2;
				String charset = "windows-1253";
				String line;		// epomeni grammi tou arxeiou html
				/*FileInputStream fstream= new FileInputStream("html.txt");
				//specify document name
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader
				(new InputStreamReader(in));
				while((line = br.readLine())!= null){
					String line1 = line.toUpperCase();
					d1 = line1.indexOf("CHARSET=");
					d2 = line1.indexOf(">");
					if (d1 > -1){
						  //String charset_tmp = line1.substring(d1+9);
						  d2 = line1.indexOf(">");
						  charset = line1.substring(d1+9, d2 );
						  d1 = charset.indexOf('"');
						  charset = charset.substring(0, d1  );
					}
				}
				in.close();
				System.out.println(charset);*/
				//stis parapanw 17 grammes anazhtoume emeis to charset kai 
				//epeita ksanadiavazoume to proramma me to kainourio charset
				//omws kapoia site (opws to aueb.gr) enw exoun charset = utf-8
				//emfanizoun ellhnika mono me to windows-1253
				String total = ""; // Ayto to string 
				//tha to steilei stin othoni tou xristi
				String title = "Javantistes Web Browser"; // ayto 
				//tha emfanizei ean den vrei titlo arxeiou
				boolean getting_html = false; // oso einai true,
				//emfanizei tis grammes
				boolean getting_javscript = false; // oso einai true,
				//emfanizei tis grammes
				FileInputStream gstream = new FileInputStream("html.txt");
				//specify document name
				DataInputStream ina = new DataInputStream(gstream);
				BufferedReader gr = new BufferedReader(new 
						InputStreamReader(ina, charset));

				while ((line = gr.readLine()) != null) {
					// Vriskei to title	(an yparxei):
					String line1 = line.toUpperCase(); // wste na 
					//katalavainei kai to body kai to BODY
					d1 = line1.indexOf("<TITLE>");
					d2 = line1.indexOf("</TITLE>");
					if ((d1 > -1) && (d2 > 0) && (d2 > d1)) {
						title = line.substring(d1 + 7, d2);
						this.setTitle(title); //me auto ton tropo 
						//emfanizei panw panw to title
					}

					// Elegxei an exei vrei to <body>:
					d1 = line1.indexOf("<BODY");
					if (d1 > -1) {
						getting_html = true;
					}
					// Elegxei an exei vrei to </body>
					d1 = line1.indexOf("</BODY");
					if (d1 > 0) {
						getting_html = false;
					}

					// Elegxei an diavzei javscript:
					d1 = line1.indexOf("<SCRIPT");
					if (d1 > -1) {
						getting_javscript = true;
					}
					// Elegxei an diavzei stamatise na diavzei javscript:
					d1 = line1.indexOf("</SCRIPT");
					if (d1 > -1) {
						getting_javscript = false;
					}


					if ((getting_html == true) && (
							getting_javscript == false)) {
						boolean basic_elements = false;
						int d3 = line1.indexOf("<TABLE");
						int d4 = line1.indexOf("<TD");
						int d5 = line1.indexOf("<TR");
						int d6 = line1.indexOf("<BR");
						int d7 = line1.indexOf("<HR");
						int d8 = line1.indexOf("<LI");
						int d9 = line1.indexOf("<UL");
						int d10 = line1.indexOf("<OL");
						int d11 = line1.indexOf("<H1");
						int d12 = line1.indexOf("<H2");
						int d13 = line1.indexOf("<H3");
						int d14 = line1.indexOf("<H4");
						int d15 = line1.indexOf("<H5");
						int d16 = line1.indexOf("<H6");
						int d17 = line1.indexOf("<IMG");
						int d18 = line1.indexOf("<P");
						int d19 = line1.indexOf("<A");
						int d20 = line1.indexOf("<SPAN");

						if ((d3 > -1) || (d4 > -1) || (d5 > -1)
								|| (d6 > -1) || (d7 > -1) || (d8 > -1)
								|| (d9 > -1) || (d10 > -1) || (d11 > -1) 
								|| (d12 > -1) 
								|| (d13 > -1) || (d14 > -1) || (d15 > -1) 
								|| (d16 > -1) || (d17 > -1) || (d18 > 1) 
								|| (d19 > 1) || (d20 > 1)) {
							basic_elements = true;
						}

						if (basic_elements == true) {
							// Kanei antiaktastasi to span me to p an einai 
							//etsi:
							String line2 = line.replaceAll("SPAN", "P");
							// Dimiourgei to string pou tha emfanisei
							//stin othoni:
							total = total + line2;
						}
					} //telos megalhs if

				} //telos while
				ina.close();
				printText(total);
				} catch (Exception ex) {
					System.out.println("An exception is caught!! ");
					ex.printStackTrace();
				}
	} //telos actionPerfomed

	public final void printText(final String text) {
			try {
				Color bgColor = Color.WHITE; //8etoume emeis bgColor
				//dioti kapoies selides xrisimopoioun css pou emeis 
				//den asxoli8ikame
				displayEditorPane.setBackground(bgColor);
				displayEditorPane.setText(text);
			} catch (Exception ex) {
				System.out.println("An exception is caught!! ");
				ex.printStackTrace();
			}
	} //telos printText
} //telos klasshs WebBrowser
