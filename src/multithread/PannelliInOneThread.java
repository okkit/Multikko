package multithread;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PannelliInOneThread extends JPanel {

	Labello mainThreadLabel;
	Labello buttonThreadLabel;
	Labello textFieldThreadLabel;
	Labello resultThreadLabel;
	Radio multithread;
	Radio nonMultithread;
	Buttoni eventButton;

	JTextField inputField;

	public PannelliInOneThread() {
		super();
		setLayout(new GridLayout(0, 1));
		init();
	}

	private void init() {
		mainThreadLabel = new Labello();
		mainThreadLabel.setText(" Main Thread: " + Thread.currentThread().getName());
		add(mainThreadLabel);

		multithread = new Radio("Simulation of an acces to data base in an own Thread");
		nonMultithread = new Radio("Without simulation of an acces to data base in the current Thread");
		nonMultithread.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(multithread);
		group.add(nonMultithread);

		add(multithread);
		add(nonMultithread);

		buttonThreadLabel = new Labello();
		buttonThreadLabel.setText(" Button event Thrad: None");
		add(buttonThreadLabel);
		eventButton = new Buttoni("Strart the simulation of an acces to data base");
		add(eventButton);
		eventButton.addActionListener(e -> eventButtonClicked());

		textFieldThreadLabel = new Labello();
		textFieldThreadLabel.setText("Type here after strart the simulation of an acces to data base");
		add(textFieldThreadLabel);
		add(inputField = new JTextField());

		resultThreadLabel = new Labello();
		resultThreadLabel.setText("Duration of the acces to Data base");
		add(resultThreadLabel);

	}

	/**
	 * Verarbeitungszeit in Sekunden. Processing time in seconds.
	 */
	private void eventButtonClicked() {

		eventButton.setLayout(true);
		eventButton.setText(" Current Thread: " + Thread.currentThread().getName());
//		resultThreadLabel.setText("Access completed. Time: " + time + " sec");
		

		long time = System.currentTimeMillis();

		if (multithread.isSelected())
			simulateRunQueriesInAnOwnThread();
		else
			simulateRunQueriesInTheMainThread();

		time = System.currentTimeMillis() - time;
		showAccesTimeInSeparateThread(time);
		eventButton.setLayout(false);
	}

	private void simulateRunQueriesInAnOwnThread() {

		Thread queryThread = new Thread() {
			public void run() {
				accesToDB();
			}
		};
		queryThread.start();

	}

	private void simulateRunQueriesInTheMainThread() {
		accesToDB();
	}

	/**
	 * Simuliert einen remote und lang andauernden Zugriff auf eine Datenbank zwecks
	 * erhaltens großer Datenmenge. <br>
	 * Die Simulation bezieht sich ausschließlich auf die Dauer des Zugriffs, d.h.
	 * in dieser Methode findet etwas statt, was viel Zeit benötigt. <br>
	 * 
	 * The simulation refers exclusively to the duration of the access, i.e. in this
	 * method something takes place that takes a lot of time. <br>
	 * Simulates a remote and long-term access to a database to obtain large amounts
	 * of data.
	 */
	private void accesToDB() {

		buttonThreadLabel.setText("runDatabaseQuery", "Thread: " + Thread.currentThread().getName());
		@SuppressWarnings("unused")
		double sum = 0;
		for (int i = 0; i < Integer.MAX_VALUE / 8; i++) {

			sum += Math.log10(i);
		}

	}

	private void showAccesTimeInCurrentThread(long time) {

		resultThreadLabel.setText("Access completed. Time: " + time + " sec");

	}

	private void showAccesTimeInSeparateThread(final long time) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println(" call showQueryResult in Thread: " + Thread.currentThread().getName());
				resultThreadLabel.setText("Access completed. Time: " + time + " sec");
			}
		});
	}

}
