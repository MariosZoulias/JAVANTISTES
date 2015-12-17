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
	private final static String newline = "\n"; //μεταβλητη για τη καινουργια γραμμη

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

	    JScrollPane scrollPane = new JScrollPane(textArea); //αλλαγη για το scrollBar
	    add(scrollPane, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		String stringUrl = textField.getText();
		URLCon urlcon = new URLCon();
		try {
			urlcon.createTxt(stringUrl);
			} catch (Exception ab) {
				System.out.println("ERROR !");
			}
		String text = "biography"; //παραδειγμα εκτυπωσης, περναω ενα string στη μεθοδο printText, εκει με την εντολη append πανω στη textArea εμφανιζω τη λεξη
		printText(text);
	}

	public void printText(String text) {
		for (int i = 0; i < 50; i++) {
			textArea.append(text + newline); // το newline ειναι αναγκαστικο για να αλλαζει γραμμη αλλιως καθε φορα θα σβηνει και θα γραφει στη 1η γραμμη
		}
	}
}
