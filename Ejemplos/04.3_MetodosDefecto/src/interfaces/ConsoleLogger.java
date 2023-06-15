package interfaces;

public class ConsoleLogger implements Loggable {

	@Override
	public void log(String s) {
		System.out.println(s);
	}

}
