package multithread;

import javax.swing.SwingUtilities;

public class QueryOwnResultOwn extends Pannelli {

	@Override
	protected void defineLabels() {

		mainLabel.setText(
				"<html>Query in an OWN thread, <br>show query result in an OWN thread, but invoke later</html>");
//		infoLabel.setText(
//				"<html> </html>");

	}

	@Override
	protected void buttonWasClicked() {

		eventButton.setText("Simulation was started. Thread: " + Thread.currentThread().getName());

		new Thread(new Runnable() {

			@Override
			public void run() {

				final String thread = Thread.currentThread().getName();
				final String text = " Time " + accesToDB();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						resultLabel.setText("DB access done in thread " + thread + text);
					}
				});

			}

		}).start();

	}
}
