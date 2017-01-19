package model;

public class Hostel {
	
	private int Id;
	private String Name;
	private String Adress;
	private int Gamme;
	private float price;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public int getGamme() {
		return Gamme;
	}
	public void setGamme(int gamme) {
		Gamme = gamme;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}
