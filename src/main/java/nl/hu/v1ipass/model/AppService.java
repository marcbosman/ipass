package nl.hu.v1ipass.model;

import java.util.List;

import nl.hu.v1ipass.persistence.PersoonDAO;

public class AppService {
	private PersoonDAO persoonDAO = new PersoonDAO();

	public List<Persoon> getAllPersonen() {
		return persoonDAO.findAll();
	}

	public boolean addPersoon(Persoon p) {
		boolean result = false;
		if (persoonDAO.save(p)) {
			result = true;
		}
		return result;
	}

	public boolean deletePersoon(Persoon p) {
		boolean result = false;
		if (persoonDAO.delete(p)) {
			result = true;
		}
		return result;
	}

	/*public boolean veranderPersoon(Persoon c) {
		boolean result = false;
		if (persoonDAO.update(c)) {
			result = true;
		}
		return result;
	}*/

	public Persoon getPersoonById(int id) {
		Persoon result = null;

		for (Persoon c : getAllPersonen()) {
			if (c.getId() == id) {
				result = c;
				break;
			}
		}

		return result;
	}
}
