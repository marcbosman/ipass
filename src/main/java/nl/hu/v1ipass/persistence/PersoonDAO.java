package nl.hu.v1ipass.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nl.hu.v1ipass.model.Persoon;

public class PersoonDAO extends BaseDAO {
	private List<Persoon> selectPersonen(String query) {
		List<Persoon> results = new ArrayList<Persoon>();
		
		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			System.out.println(query);
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				String adres = dbResultSet.getString("adres");
				String woonplaats = dbResultSet.getString("woonplaats");
				int telefoonnummer = dbResultSet.getInt("telefoonnummer");
				String bijzonderheden = dbResultSet.getString("bijzonderheden");
				Date geboortedatum = dbResultSet.getDate("geboortedatum");
				String email = dbResultSet.getString("email");
				String huisarts = dbResultSet.getString("huisarts");
				String naam = dbResultSet.getString("naam");
				String groep = dbResultSet.getString("groep");
				String rol = dbResultSet.getString("rol");
				Persoon newPersoon = new Persoon(id, adres, woonplaats, telefoonnummer, bijzonderheden, geboortedatum, email, huisarts, naam, groep, rol);
				results.add(newPersoon);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}

	public boolean save(Persoon persoon) {
		String query = "INSERT INTO PERSOON(id, adres, woonplaats, telefoonnummer, bijzonderheden, geboortedatum, email, huisarts, naam, groep, rol) VALUES("
				+ persoon.getId() + ", " + persoon.getAdres() + ", " + persoon.getWoonplaats() + ", "
				+ persoon.getTelefoonnummer() + ", " + persoon.getBijzonderheden() + ", " + persoon.getGeboortedatum() + ", "
				+ persoon.getEmail() + ", " + persoon.getHuisarts() + ", " + persoon.getNaam() + ", "
				+ persoon.getGroep() + ", " + persoon.getRol() + ");";
		//System.out.println(query);
		boolean result = false;
		try (Connection con = getConnection()) {

			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			result = true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}

	public List<Persoon> findAll() {
		return selectPersonen(
				"SELECT * FROM PERSOON;");
	}

	public Persoon findById(int id) {
		return selectPersonen(
				"SELECT * FROM country WHERE id = '"
						+ id + "';").get(0);
	}

	/*public boolean update(Persoon persoon) {
		String query = "UPDATE ...;";
		boolean result = false;
		try (Connection con = getConnection()) {

			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			result = true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}*/

	public boolean delete(Persoon persoon) {
		boolean result = false;
		boolean persoonExists = findById(persoon.getId()) != null;

		if (persoonExists) {
			String query = "DELETE FROM PERSOON WHERE ID = '" + persoon.getId() + "';";

			try (Connection con = getConnection()) {

				Statement stmt = con.createStatement();
				if (stmt.executeUpdate(query) == 1) { // 1 row updated!
					result = true;
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return result;
	}
}