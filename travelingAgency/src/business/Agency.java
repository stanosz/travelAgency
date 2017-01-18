package business;
import model.Hotel;
import model.Excursion;
import java.util.List;
import java.util.ArrayList;
import persistance.JdbcPersistence;

public class Agency {
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private List<Excursion> Execusion = new ArrayList<Excursion>();

	public List<Hotel> getHotels() {
		return hotels;
	}

	public List<Excursion> getExcursion() {
		return Execusion;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	public void createOffer(){
		
	}

}
