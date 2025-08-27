package multithread;

import java.awt.Color;

import javax.swing.JLabel;

public class Labello extends JLabel implements Layout{
	
	public Labello() {
		super();
		setFont(FONT);
	}
	
	public Labello(int whatFor) {
		super();
		switch (whatFor) {
		case 1: {
			setFont(BIG_FONT);
			break;
		}
		case 2: {
			setFont(INFO_FONT);
			setForeground(Color.RED);
			break;
		}
		default:
			setFont(FONT);
			break;
		}
		
	}

	public Labello(String title) {
		this();
		setText(title);
	}
	
	public void setText(String txt1, String txt2) {
		String txt = "<html>" + txt1 + "<br>" + txt2 + "</html>";
		setText(txt);
	}

}
