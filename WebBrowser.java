import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		String text = "biography"; //paradeigma ektyposis, pernaw ena string sti methodo printText, ekei me thn entolh append panw sth textArea emfanizv to string
		printText(text);//tis grammes 57-58 afou katalavete pws doulevoun profanws svhste tes
	}

	public void printText(String text) {
			textArea.append(text + newline); // to newline einai anagkastiko gia na allazei grammh alliw kathe fora tha svinei kai tha grafei sth 1h grammh
	}
}
