package model;

public class Hotel {
	private int Id;
	private String Name;
	private int Gamme;
	private float prix;
	private String Adress;
	
	
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
	public int getGamme() {
		return Gamme;
	}
	public void setGamme(int gamme) {
		Gamme = gamme;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
}

