import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class WebBrowser_1 extends JFrame implements ActionListener {

	private JPanel middlePanel;
	private JTextField textField;
	private JTextArea textArea;
	private static final String newline = "\n"; //metavliti
	//gia tin kainourgia grammi

	public static void main(final String[] args) {
		WebBrowser_1 frame = new WebBrowser_1();
		frame.setTitle("Javantistes Web Browser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 400);
		frame.setVisible(true);
	}

	public WebBrowser_1() {
		middlePanel = new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	    middlePanel.add(new JLabel("URL:"));

	    middlePanel.add(textField = new JTextField(40));
	    textField.setToolTipText("Enter URL");
	    getContentPane().add(middlePanel, BorderLayout.NORTH);

	    textField.addActionListener(this);

	    textArea = new JTextArea();
	    textArea.setEditable(false);
	    getContentPane().add(textArea, BorderLayout.CENTER);

	    JScrollPane scrollPane = new JScrollPane(textArea); //allagi
	    //gia to scrollBar
	    add(scrollPane, BorderLayout.CENTER);

	}

	public final void actionPerformed(final ActionEvent e) {
		String stringUrl = textField.getText();
		URLCon urlcon = new URLCon();
		try {
			urlcon.createTxt(stringUrl);
			} catch (Exception ab) {
				printText("ERROR. You insected unexisted URL !");
			} //ftiaxnei antikeimeno ths URLCon kai kalei thn metodo createTxt()
			String encoding = "UTF-8";
			//ftiaxnei antikeimeno ths klasshs Tags_1
			Tags_1 tag_1 = new Tags_1();
							try {
//kanei thn idia douleia me to arxeio java.java dhladh diabazei
								//ton kwdika grammh grammh
								FileInputStream fstream = new
										FileInputStream("m.txt"); //specify
								//document name
								DataInputStream in = new
										DataInputStream(fstream);
								BufferedReader br = new BufferedReader(
										new InputStreamReader(in, encoding));

								String line;
								while ((line = br.readLine()) != null) {
									if (line.contains("<p")) {
//an brei tag p (dld "<p" ) tote kalei kai aksiopoiei th me8odo p ths Tags_1
//ayth h diadikasia ginetai pleon edw wste na emfanizetai
//oxi sto cmd alla sayto pou eftiakse o ladopoulos
										printText(tag_1.p(line));
									}
//an brei tag title (dld "<title" ) tote kalei kai
//aksiopoiei th me8odo p ths Tags_1
									if (line.contains("<title")) {
										printText(tag_1.title(line));
									}
									/*if(line.contains("<strong")){
//an brei tag strong (dld "<strong" ) tote kalei kai
  aksiopoiei th me8odo p ths Tags_1
										printText(tag_1.p(line));
									}
									if(line.contains("<a")){
//an brei tag a (dld "<a" ) tote kalei kai
  aksiopoiei th me8odo p ths Tags_1
										printText(tag_1.p(line));
									}
								        //h <ul> den xreiazetai, kathoti
								          h <li> einai hdh arketh
								        if(line.contains("<li")){
//an brei tag li (dId "<li") tote kalei kai aksiopoiei th me8odo li ths Tags_1
										printText("   *" + tag_1.li(line));
								        }*/
								    //ta kleinoume ws edw dioti ta
									//parapanw tags einai
									//emfwleumena kai epomenws petietai error

									if (line.contains("<br>")) {
										line = line.replace("<br>", "/n");
										printText(line);
									}


									if (line.contains("<hr>")) {
										printText(tag_1.hr(line));
									}
								}
								in.close();

							} catch (Exception ex) {
								System.out.println("An exception is caught!! ");
								ex.printStackTrace();
							}
	}

	public final void printText(final String text) {
			textArea.append(text + newline); // to newline einai
			//anagkastiko gia na allazei
			//grammh alliw kathe fora tha svinei kai tha grafei sth 1h grammh
	}
}
