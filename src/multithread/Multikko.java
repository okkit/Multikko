package multithread;

import java.awt.HeadlessException;

import javax.swing.JFrame;
public class Multikko extends JFrame {


	public Multikko(ThreadingMode awtAwt) throws HeadlessException {
		
		super("Multikko");
		setBounds(600, 100, 600, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Pannelli panel;
		
		switch (awtAwt) {
		case BOTH_IN_AWT: {
			panel = new QueryAwtResultAwt();
			break;
		}
		case BOTH_IN_OWN: {
			panel = new BothThesameSeparate();
			break;
		}
		case OWN_AWT: {
			panel = new QueryOwnResultAwt();
			break;
		}
		case OWN_OWN: {
			panel = new QueryOwnResultOwn();
			break;
		}
		default:
			panel = new QueryAwtResultAwt();
			break;
		}
		add(panel);
		setVisible(true);
		System.out.println("Multikko start in thread " + Thread.currentThread().getName());
	}

}
