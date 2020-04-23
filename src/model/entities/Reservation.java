package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                                             //SE FOR extends RuntimeException NÃO PRECISARIA PROPAGAR O ERRO (PODE APAGAR O throws)
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)){      //COLOCAR TB NO CONSTRUTOR PQ NO PRIMEIRO LANÇAMENTO JA PODE DAR ESSE ERRO
			throw new DomainException("Check-out data must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;

		

	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() { // tipo long pois irá retornar um numero muito grande - milessegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
                              //SE FOR extends RuntimeException NÃO PRECISARIA PROPAGAR O ERRO (PODE APAGAR O throws)
	public void updateDates(Date checkIn, Date checkOut) throws DomainException{ 
		                                                 //POR CAUSA DA EXCEÇÃO PERSONALIZADA DomainException TEMOS QUE PROPAGAR A EXCEÇÃO AQUI NO METODO
		Date now = new Date();   // metodo now - data agora!
		if(checkIn.before(now) || checkOut.before(now)){  // se checkin ou checkout forem antes do now 
			throw new DomainException("Reservation dates for update must be future dates");
		}   //throw - lançar, o argumento é existente no java
		if (!checkOut.after(checkIn)){
			throw new DomainException("Check-out data must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		//se retornar nulo é pq não deu nenhum erro(como é um método String tem que retornar texto.
	}

	@Override
	public String toString(){
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+", "
				+ duration()
				+ " nights";
				
	}

}
