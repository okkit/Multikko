package multithread;

import javax.swing.SwingUtilities;

public class QueryOwnResultOwn extends Pannelli {

	@Override
	protected void defineLabels() {

		mainLabel.setText(
				"<html>Query in an OWN thread, <br>show query result in an OWN thread, but invoke later</html>");
	}

	@Override
	protected void buttonWasClicked() {

		eventButton.setText("Simulation was started. Thread: " + Thread.currentThread().getName());

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				final String text = " Time " + new DBAccessSimulation().accessToDB();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						resultLabel.setText("Show DB acces result in thread "
								+ Thread.currentThread().getName() + text);
					}
				});

			}

		});
		System.out.println(
				" Start thread " + thread.getName() + " for showing result and invoke it later");
		thread.start();

	}
}
