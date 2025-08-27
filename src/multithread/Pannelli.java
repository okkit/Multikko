package multithread;

import java.awt.GridLayout;

import javax.swing.JPanel;

public abstract class Pannelli extends JPanel {

	Labello mainLabel; // What is running
	Labello infoLabel; // Info what to expect
	Buttoni eventButton; // To initiate a simulation of long-lasting access to the database
	Textii inputField; // For testing of ui-input
	Labello resultLabel; // Result after database access was done

	long time;

	public Pannelli() {
		super();
		setLayout(new GridLayout(0, 1));
		init();
		defineLabels();
	}

	private void init() {
		mainLabel = new Labello(1);
		add(mainLabel);
		
		infoLabel = new Labello(2);
		add(infoLabel);

		eventButton = new Buttoni("Start the simulation of a long-lasting access to data base");
		add(eventButton);
		eventButton.addActionListener(e -> buttonWasClicked());

		add(inputField = new Textii("Type something in this field after simulation started"));
		add(resultLabel = new Labello("Result after database access was done"));
	}

	protected abstract void defineLabels();
	protected abstract void buttonWasClicked();
//	{
//		System.out.println(" call RunQueries in Thread: " + Thread.currentThread().getName());
//		eventButton.setText("Simulation was started. Thread: " + Thread.currentThread().getName());
//		callRunQueries();
//		System.out
//				.println(" Show Simulation Result in Thread: " + Thread.currentThread().getName());
//		showQueryResult();
//	}


	/**
	 * Simuliert einen remote und lang andauernden Zugriff auf eine Datenbank zwecks
	 * erhaltens gro�er Datenmenge. <br>
	 * Die Simulation bezieht sich ausschlie�lich auf die Dauer des Zugriffs, d.h.
	 * in dieser Methode findet etwas statt, was viel Zeit ben�tigt. <br>
	 * 
	 * The simulation refers exclusively to the duration of the access, i.e. in this
	 * method something takes place that takes a lot of time. <br>
	 * Simulates a remote and long-term access to a database to obtain large amounts
	 * of data.
	 */
	protected long accesToDB() {

		System.out
				.println(" Beginning of accesToDB in Thread: " + Thread.currentThread().getName());
		long t = System.currentTimeMillis();
		@SuppressWarnings("unused")
		double sum = 0;
		for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {

			sum += Math.log10(i);
		}

		time = System.currentTimeMillis() - t;
//		resultLabel.setText("DB access time: " + time);
//		eventButton.setText("Queries is done in Thread " + Thread.currentThread().getName());
		return time;
	}

	protected void accesToDB(Result result) {

		long t = System.currentTimeMillis();
		@SuppressWarnings("unused")
		double sum = 0;
		for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {

			sum += Math.log10(i);
		}

		result.thread = Thread.currentThread().getName();
		result.time = System.currentTimeMillis() - t;

	}

}
