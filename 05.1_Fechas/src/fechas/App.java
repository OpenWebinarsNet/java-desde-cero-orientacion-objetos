package fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {

	public static void main(String[] args) {

		LocalDate hoy = LocalDate.now();
		System.out.println(hoy);
		
		LocalDate ayer = hoy.minus(1, ChronoUnit.DAYS);
		System.out.println(ayer);
		
		LocalDate manana = hoy.plusDays(1);
		System.out.println(manana);
		
		LocalDate enUnMes = hoy.plusMonths(1);
		System.out.println(enUnMes);
		
		LocalDate fechaFija = LocalDate.of(2010, 07, 10);
		System.out.println(fechaFija);
		
		LocalDate fechaTexto = LocalDate.parse("2020-01-01");
		System.out.println(fechaTexto);
		
		LocalDate fechaTexto2 = LocalDate.parse("01/01/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(fechaTexto2);
		
		String textoFecha = fechaTexto2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(textoFecha);
		
		if (hoy.isAfter(ayer)) 
			System.out.println("Normal, hoy está después que ayer, y antes que mañana");
		
		
	}

}
