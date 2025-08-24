package multithread;

import java.awt.HeadlessException;

import javax.swing.JFrame;
enum Mode{
	AWT_AWT,
	AWT_OWN,
	OWN_AWT,
	OWN_OWN
}
public class Multikko extends JFrame {

	private Mode mode = Mode.OWN_AWT;

	public Multikko() throws HeadlessException {
		super("Multikko");

		System.out.println(getClass().getSimpleName() + ": Thread: " + Thread.currentThread().getName());
		
		setBounds(600, 100, 1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Pannelli panel;
		
		switch (mode) {
		case AWT_AWT: {
			panel = new QueryAwtResultAwt();
			break;
		}
		case AWT_OWN: {
			panel = new QueryAwtResultOwn();
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
	}

	public static void main(String[] args) {

		System.out.println("Main: Thread: " + Thread.currentThread().getName());
		new Multikko();

	}

}
