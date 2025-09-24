package multithread;

import javax.swing.SwingUtilities;

public class QueryOwnResultInvokeLater extends Pannelli {

	@Override
	protected void buttonWasClicked() {

		eventButton.setText("Simulation was started. Thread: " + Thread.currentThread().getName());
		Thread thread = new Thread() {

			@Override
			public void run() {

				System.out.println(
						" Create Runnable for showing result and invoke it later");
				final String text = " Time " + new DBAccessSimulation().accessToDB();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						resultLabel.setText("Show DB acces result in thread "
								+ Thread.currentThread().getName() + text);
					}
				});
			}
		};
		System.out.println(
				" Start thread " + thread.getName() + " for DB-access");
		thread.start();

	}
	
	@Override
	protected void defineLabels() {

		mainLabel.setText(
				"<html>Query and show Result in a separatly thread, <br>show query result as Runnable with invoking later</html>");
	}

}
