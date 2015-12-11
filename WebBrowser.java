import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WebBrowser extends JFrame implements ActionListener {

	private JPanel middlePanel;
	private JTextField textField;
	private JLabel label;
	private JEditorPane editorPane;
	private JEditorPane displayEditorPane;
	private JTextArea textArea;
	private JScrollBar scrollBar;

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

	    scrollBar = new JScrollBar();
	    getContentPane().add(scrollBar, BorderLayout.EAST);

	}

	public void actionPerformed(ActionEvent e) {
		String stringUrl = textField.getText();
		URLCon urlcon = new URLCon();
		try {
		urlcon.createTxt(stringUrl);
		} catch(Exception exc) {
			System.out.println("Exception !");
		  }
	}



}

