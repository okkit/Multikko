package multithread;

import java.awt.Color;

public class BothThesameSeparate extends Pannelli {

	protected void buttonWasClicked() {

		eventButton.setText("Simulation was started. Thread: " + Thread.currentThread().getName());

		new Thread() {

			@Override
			public void run() {

				String thread = Thread.currentThread().getName();
				String text = " Time " + new DBAccessSimulation().accessToDB();

				resultLabel.setText("Show DB acces result in thread " + thread + text);
			}

		}.start();
		if (resultLabel.getText().indexOf("Time") != -1) {
			eventButton.setBackground(Color.GRAY);
		}
	}
	
	@Override
	protected void defineLabels() {

		mainLabel.setText(
				"<html>Query start in a separate thread, <br>show query result in the same thread as the DB access.</html>");
		infoLabel.setText("<html>After button was clicked DB acces is running a lot of time,<br> "
				+ "but the result will be showed in the same thread as DB access! </html>");

	}

}
