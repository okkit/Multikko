package multithread;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Buttoni extends JButton{

	public Buttoni(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.ITALIC, 22));
		setBackground(new Color(134, 198, 236));
		setFocusable(false);
	}
	
	void setLayout(boolean clicked) {
		if (clicked)
			setBackground(new Color(34, 98, 136));
		else
			setBackground(new Color(134, 198, 236));
	}

}
