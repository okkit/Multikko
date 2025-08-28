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

}
