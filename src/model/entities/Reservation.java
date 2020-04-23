package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();   // metodo now - data agora!
		if(checkIn.before(now) || checkOut.before(now)){  // se checkin ou checkout forem antes do now (agora)
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)){
			return "Check-out data must be after check-in date";
		}   //se passar pelas duas logicas acima, ai sim irá atualizar as datas de checkin e checkout
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; //se retornar nulo é pq não deu nenhum erro(como é um método String tem que retornar texto.
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
