package multithread;

import javax.swing.SwingUtilities;

public class QueryAwtResultOwn extends Pannelli {

	@Override
	protected void defineLabels() {

		mainLabel.setText("Query in an AWT thread, show query result in an OWN thread, but invoke later");

	}

	@Override
	protected void callRunQueries() {

		accesToDB();
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
