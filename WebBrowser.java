import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WebBrowser extends JFrame implements ActionListener {

	private JPanel middlePanel;
	private JTextField textField;
	private JLabel label;
	private JTextArea textArea;
	private final static String newline = "\n"; //metavliti gia tin kainourgia grammi

	public static void main(String[] args) {
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

	    textArea = new JTextArea();
	    textArea.setEditable(false);
	    getContentPane().add(textArea, BorderLayout.CENTER);

	    JScrollPane scrollPane = new JScrollPane(textArea); //allagi gia to scrollBar
	    add(scrollPane, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		String stringUrl = textField.getText();
		URLCon urlcon = new URLCon();
		try {
			urlcon.createTxt(stringUrl);
			} catch (Exception ab) {
				printText("ERROR !");
			}
			String encoding = "UTF-8";
			//ftiaxnei antikeimeno ths klasshs Tags_1
			Tags_1 tag_1 = new Tags_1();
							try{
//kanei thn idia douleia me to arxeio java.java dhladh diabazei ton kwdika grammh grammh
								FileInputStream fstream= new FileInputStream("m.txt");//specify document name
								DataInputStream in= new DataInputStream(fstream);
								BufferedReader br=new BufferedReader(new InputStreamReader(in , encoding));

								String line;
								while((line=br.readLine())!= null){
									if(line.contains("<p")){
//an brei tag p (dld "<p" ) tote kalei kai aksiopoiei th me8odo p ths Tags_1
//ayth h diadikasia ginetai pleon edw wste na emfanizetai oxi sto cmd alla sayto pou eftiakse o ladopoulos
										printText(tag_1.p(line));
									}
									if(line.contains("<title")){
										printText(tag_1.title(line));
									}
								}
								in.close();

							}
							catch(Exception ex){
								System.out.println("An exception is caught!! ");
								ex.printStackTrace();
							}
	}

	public void printText(String text) {
			textArea.append(text + newline); // to newline einai anagkastiko gia na allazei grammh alliw kathe fora tha svinei kai tha grafei sth 1h grammh
	}
}
