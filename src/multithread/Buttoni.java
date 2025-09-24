package multithread;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Buttoni extends JButton implements Layout{

	public Buttoni(String text) {
		this();
		setText("Button: " + text);
		
	}
	
	public Buttoni() {
		setFont(FONT);
//		setBackground(new Color(134, 198, 236));
		setHorizontalAlignment(SwingConstants.LEFT);
		setFocusable(false);
	}

	void setLayout(boolean clicked) {
		if (clicked)
			setBackground(new Color(34, 98, 136));
		else
			setBackground(new Color(134, 198, 236));
	}

}
