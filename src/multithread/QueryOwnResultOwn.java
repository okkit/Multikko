package multithread;

import javax.swing.SwingUtilities;

public class QueryOwnResultOwn extends Pannelli{

	@Override
	protected void defineLabels() {
		
		mainLabel.setText("Query in the OWN thread, show query result in an OWN thread, but invoke later");
		
	}

	@Override
	protected void callRunQueries() {
		Thread queryThread = new Thread() {
			public void run() {
				accesToDB();
			}
		};
		queryThread.start();
		
	}

	@Override
	protected void showQueryResult() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println(" in showQueryResult : " + Thread.currentThread().getName());
				resultThreadLabel.setText("Query is done!");
			}
		});
		
	}

}
