package multithread;

public class QueryAwtResultAwt extends Pannelli {

	@Override
	protected void defineLabels() {

		mainLabel.setText("Start Query in the AWT thread, Result of course in the AWT thread too");
		infoLabel.setText(
				"<html>After button was clicked the text of the button and the text of the input field <br>"
						+ "will be changed programmatically. But you see this after DB acces is finished! </html>");
	}

	@Override
	protected void buttonWasClicked() {

		eventButton.setText("Simulation was started. Thread: " + Thread.currentThread().getName());
		inputField
				.setText("You cannot type here because DB access is blocking the AWT event queue!");

		String thread = Thread.currentThread().getName();
		String text = " Time " + accesToDB();
		resultLabel.setText("DB access done in thread " + thread + text);

	}
}
