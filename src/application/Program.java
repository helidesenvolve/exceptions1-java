package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { // trows -
																	// propagar
																	// a exce��o
																	// (parse)

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) { // date tem um metodo after que testa se uma data e�depois da outra 
	   // se o checkout nao � depois do checkin (� um erro)
			System.out.println("Error in reservation: Check-out date must be after check-in date");
			//se imprimir quer dizer que as datas sao invalidas																						// acontecer
																									
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();   // metodo now - data agora!
			if(checkIn.before(now) || checkOut.before(now)){  // se checkin ou checkout forem antes do now (agora)
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)){
				System.out.println("Error in reservation: Check-out data must be after check-in date");
			}
			else{
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			
		}
		
		sc.close();

	}
}
