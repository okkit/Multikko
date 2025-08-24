package multithread;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Pannelli extends JPanel {

	Labello mainLabel;
	Labello textFieldThreadLabel;
	Labello resultThreadLabel;
	Buttoni eventButton;

	JTextField inputField;

	public Pannelli() {
		super();
		setLayout(new GridLayout(0, 1));
		init();
		defineLabels();
	}

	private void init() {
		mainLabel = new Labello();
		add(mainLabel);
		
		eventButton = new Buttoni("Strart the simulation of an acces to data base");
		add(eventButton);
		eventButton.addActionListener(e -> buttonWasClicked());
		
		add(inputField = new JTextField("Tippe was nach dem Klicken auf den Button"));
		add(resultThreadLabel = new Labello());
	}

	/**
	 * 
	 */
	
	protected void buttonWasClicked() {
		System.out.println(" call RunQueries in Thread: " + Thread.currentThread().getName());
		callRunQueries();
		System.out.println(" call showQueryResult in Thread: " + Thread.currentThread().getName());
		showQueryResult();
	}
	
	protected abstract void defineLabels();

	protected abstract void callRunQueries();
	
	protected abstract void showQueryResult();

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
	protected void accesToDB() {
		
		System.out.println(" Beginning of accesToDB in Thread: " + Thread.currentThread().getName());
		long time = System.currentTimeMillis();
		@SuppressWarnings("unused")
		double sum = 0;
		for (int i = 0; i < Integer.MAX_VALUE / 8; i++) {

			sum += Math.log10(i);
		}
		
		time = System.currentTimeMillis() - time;
		System.out.println(" Time of the accesToDB " + time + "ms");

	}

}
