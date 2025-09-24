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
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		String iconPath = "specht.png";
		ImageIcon img = new ImageIcon(iconPath);
		setIconImage(img.getImage());
		setBounds(200, 100, 600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1));

		Labello lab = new Labello();
		String txt = "<html><p color=\"#ff3366\">Please run the tests separately: only run a test when no other test is currently running. <br>"
				+ "Otherwise, the experiment may be corrupted.</p></html>";
		lab.setText(txt);
//		add(lab);

		Buttoni b = new Buttoni();
		b.setText("Test A: Start DB access & show Result. BOTH in AWT-Thread");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Multikko(ThreadingMode.BOTH_IN_AWT);
			}
		});
		add(b);

		b = new Buttoni();
		b.setText("Test B: Start DB access IN AN OWN THREAD. Show Result in AWT-thread");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Multikko(ThreadingMode.OWN_AWT);
			}
		});
		add(b);

		b = new Buttoni();
		b.setText("Test C: Start DB access and show Result. BOTH IN THE SAME BUT NON AWT-thread");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Multikko(ThreadingMode.BOTH_IN_OWN);
			}
		});
		add(b);

		b = new Buttoni();
		b.setText("Test D: As in the Case C: BUT show Result will be invoke later");
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

//		System.out.println("Programm start in thread " + Thread.currentThread().getName());

//		long time = System.currentTimeMillis();
//		time = System.currentTimeMillis();
//		SwingUtilities.invokeLater(() -> new StartTests().setVisible(true));
		new StartTests();
//		time = System.currentTimeMillis() - time;

//		System.out.println("Time for the Starting of GUI " + time);
	}
}
