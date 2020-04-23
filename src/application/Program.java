package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) { //apagou o trows pq o programa n�o vai mais porpagar a exce��o, 																	// propagar
                                             // vamos agora tratar a exce��o e n�o propaga-la.    
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try{
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}	
		catch(ParseException e){
			System.out.println("Invalid date format"); //erro no formato da data
		}
		catch(DomainException e){
			System.out.println("Error in reservation: " + e.getMessage());//pega a mensagem do IllegalArgumentException
		}                                                                 //da classe Reservation
		catch(RuntimeException e){
			System.out.println("Unexpected error");  //QQ OUTRO ERRO 
		}
		
		
		sc.close();

	}
}
