package multithread;

public class QueryAwtResultAwt extends Pannelli {

	@Override
	protected void defineLabels() {

		mainLabel.setText("Query in the AWT thread, Result in in the AWT thread");

	}

	@Override
	protected void callRunQueries() {

		accesToDB();

	}

	@Override
	protected void showQueryResult() {

		resultThreadLabel.setText("Query is done!");

	}

}
