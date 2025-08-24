package multithread;

public class QueryOwnResultAwt extends Pannelli {

	@Override
	protected void defineLabels() {

		mainLabel.setText("Query in the OWN thread, Result in in the AWT thread");

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

		resultThreadLabel.setText("Query is done!");

	}

}
