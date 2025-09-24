package multithread;

public class DBAccessSimulation {

	/**
	 * Simuliert einen remote und lang andauernden Zugriff auf eine Datenbank zwecks
	 * erhaltens gro�er Datenmenge. <br>
	 * Die Simulation bezieht sich ausschlie�lich auf die Dauer des Zugriffs, d.h.
	 * in dieser Methode findet etwas statt, was viel Zeit ben�tigt. <br>
	 * 
	 * The simulation refers exclusively to the duration of the access, i.e. in this
	 * method something takes place that takes a lot of time. <br>
	 * Simulates a remote and long-term access to a database to obtain large amounts
	 * of data.
	 * 
	 * @param duration time in ms
	 */
	public long accessToDB() {

		System.out
				.println("Beginning of accesToDB in Thread: " + Thread.currentThread().getName());
		long time = System.currentTimeMillis();
		@SuppressWarnings("unused")
		double sum = 0;
		for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {

			sum += Math.log10(i);
		}		
		time = System.currentTimeMillis() - time;
		return time;
	}

	/**
	 * The same as public long accessToDB(), but with save time in an result-Object 
	 * @param result
	 */
	public void accessToDB(Result result) {

		result.time = accessToDB();
	}
}

