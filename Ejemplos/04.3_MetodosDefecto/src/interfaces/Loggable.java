package interfaces;

public interface Loggable {
	
	void log(String s);
	
	default void logArray(String[] array) {
		for (String s : array) {
			log(s);
		}
	}

}
