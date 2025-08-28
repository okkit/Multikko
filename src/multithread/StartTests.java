package multithread;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class StartTests extends JFrame {

	public StartTests() throws HeadlessException {
		super("Multikko");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String iconPath = "specht.png";
		ImageIcon img = new ImageIcon(iconPath);
		setIconImage(img.getImage());
		setBounds(200, 100, 580, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1));

		Buttoni b = new Buttoni("Start DB access & show Result both in AWT-Thread");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Multikko(ThreadingMode.BOTH_IN_AWT);
			}
		});
		add(b);

		b = new Buttoni("Start DB access in an own thread (Result in AWT-thread)");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				SwingUtilities
//						.invokeLater(() -> new Multikko(ThreadingMode.OWN_AWT).setVisible(true));
				new Multikko(ThreadingMode.OWN_AWT);
			}
		});
		add(b);

		b = new Buttoni(
				"Start DB access and show Result both in the same, but in an non AWT-thread");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Multikko(ThreadingMode.BOTH_IN_OWN);
			}
		});
		add(b);

		b = new Buttoni("Start DB access in its own thread, show Result in its own thread");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Multikko(ThreadingMode.OWN_OWN);
			}
		});
		add(b);

		setVisible(true);
	}

	public static void main(String[] args) {

		System.out.println("Programm start in thread " + Thread.currentThread().getName());

		long time = System.currentTimeMillis();
		time = System.currentTimeMillis();
		//SwingUtilities.invokeLater(() -> new StartTests().setVisible(true));
		new StartTests();
		time = System.currentTimeMillis() - time;
	}
}
