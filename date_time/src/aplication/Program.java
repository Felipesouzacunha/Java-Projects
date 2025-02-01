package aplication;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Program {

	public static void main(String[] args) {
		//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		
		
		
		// Data e hora atual
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();
		
		// Gerar data e hora a pertir do texto ISO 8601
		LocalDate d04 = LocalDate.parse("2025-01-31");
		LocalDateTime d05 = LocalDateTime.parse("2025-01-31T12:10:03");
		Instant d06 = Instant.parse("2025-01-31T12:10:03z");
		Instant d07 = Instant.parse("2025-01-31T12:10:03-03:00");
		
		//instnaciar data e hora a partir de um padrão custmizado
		DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDate d08 = LocalDate.parse("31/01/2025", fmt01);
		LocalDateTime d09 = LocalDateTime.parse("31/01/2025 12:28", fmt02);
		
		//instanciar datas a partir de datas isoladas
		LocalDate d10 = LocalDate.of(2025, 01, 31);
		LocalDateTime d11 = LocalDateTime.of(2025, 01, 31, 12, 34);
		
		/*System.out.println("d01 = " + d01);
		System.out.println("d02 = " + d02);
		System.out.println("d03 = " + d03);
		System.out.println("d04 = " + d04);
		System.out.println("d05 = " + d05);
		System.out.println("d06 = " + d06);
		System.out.println("d07 = " + d07);
		System.out.println("d08 = " + d08);
		System.out.println("d09 = " + d09);
		System.out.println("d10 = " + d10);
		System.out.println("d11 = " + d11);*/
		
		
		
		System.out.println();
		d04 = LocalDate.parse("2025-01-31");
		d05 = LocalDateTime.parse("2025-01-31T12:10:03");
		d06 = Instant.parse("2025-01-31T12:10:03z");
		
		//Formatar data e hora
		fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	 	DateTimeFormatter fmt03 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		
		System.out.println("d04 = " + fmt01.format(d04));
		System.out.println("d05 = " + fmt02.format(d05));
		System.out.println("d06 = " + fmt03.format(d06));
		
		
		d04 = LocalDate.parse("2025-01-31");
		d05 = LocalDateTime.parse("2025-01-31T12:10:03");
		d06 = Instant.parse("2025-01-31T12:10:03z");
		
		LocalDate r1 = LocalDate.ofInstant(d06,	ZoneId.systemDefault());
		LocalDateTime r2 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		
		System.out.println(d04.getDayOfMonth());
	}

}
