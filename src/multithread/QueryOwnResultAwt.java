package multithread;

public class QueryOwnResultAwt extends Pannelli {

	@Override
	protected void defineLabels() {

		mainLabel.setText("Query in the OWN thread, Result in in the AWT thread");
		infoLabel.setText(
				"<html>After button was clicked DB acces is running a lot of time,<br> the result (still empty) will be showed before the acces is completed! </html>");

	}

	@Override
	protected void buttonWasClicked() {

		eventButton.setText("Simulation was started. Thread: " + Thread.currentThread().getName());
		Result res = new Result();
		new Thread(new Runnable() {

			@Override
			public void run() {
				new DBAccessSimulation().accessToDB(res);
			}

		}).start();
		resultLabel.setText("DB access done in thread " + res.thread + " Time " + res.time);
	}

}
