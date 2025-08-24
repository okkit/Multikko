package multithread;

import java.awt.Font;

import javax.swing.JLabel;

public class Labello extends JLabel{

	public Labello() {
		super();
		setFont(new Font("Helvetica", Font.ITALIC, 22));
	}
	
	public void setText(String txt1, String txt2) {
		String txt = "<html>" + txt1 + "<br>" + txt2 + "</html>";
		setText(txt);
	}

}
