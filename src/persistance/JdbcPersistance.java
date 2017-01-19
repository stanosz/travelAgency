package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Excursion;
import model.Hostel;



public class JdbcPersistance  {

	private static String host = "localhost";
	private static String base = "travel";
	private static String user = "root";
	private static String password = "admin";
	private static String url = "jdbc:mysql://" + host + "/" + base;

	/**
	 * Lazy singleton instance.
	 */
	private Connection connection;
	
	public JdbcPersistance() {
		prepareConnection();
	}

	private void prepareConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}

	public List<Excursion> ListExcursion () {
		List<Excursion> le=new ArrayList<Excursion>();
		String selecttripQuery = "SELECT id_trip,name,description,cost,type_trip FROM trip ";
		try {

			
			PreparedStatement preparedStatement = connection.prepareStatement(selecttripQuery);
			
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
			Excursion ex=new Excursion();
			ex.setId(result.getInt("id_trip"));
			ex.setName(result.getString("name"));
			ex.setDescription(result.getString("description"));
			ex.setPrice(result.getFloat("cost"));
			ex.setType(result.getString("type_trip"));
			
			le.add(ex);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return le;
	}
	
	public List<Hostel> ListHostel () {
		List<Hostel> lh=new ArrayList<Hostel>();
		String selecttripQuery = "SELECT id_hostel,name_hostel,adress_hostel,scale_hostel,cost_hostel FROM hostel ";
		try {

			
			PreparedStatement preparedStatement = connection.prepareStatement(selecttripQuery);
			
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
			Hostel ht=new Hostel();
			ht.setId(result.getInt("id_trip"));
			ht.setName(result.getString("name_hostel"));
			ht.setAdress(result.getString("adress_hostel"));
			ht.setGamme(result.getInt("scale_hostel"));
			ht.setPrice(result.getFloat("cost_hostel"));
			
			lh.add(ht);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return lh;
	}
	
	
	

}
