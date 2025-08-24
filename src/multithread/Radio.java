package multithread;

import java.awt.Font;

import javax.swing.JRadioButton;

public class Radio extends JRadioButton{
	
	public Radio(String txt) {
		super(txt);
		setFont(new Font("Helvetica", Font.ITALIC, 22));
		setFocusable(false);
	}

}
