package hotel;

import java.time.LocalDate;

public interface UtilFechas {
	
	static boolean overlaps(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
		return (start1.isBefore(end2) && start2.isBefore(end1));
	}

}
