package nl.hu.v1ipass.webservices;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import nl.hu.v1ipass.model.AppService;
import nl.hu.v1ipass.model.Persoon;
import nl.hu.v1ipass.model.ServiceProvider;

@Path("/personen")
public class AppResource {
	AppService service = ServiceProvider.getAppService();

	@GET
	@Produces("application/json")
	public String getPersonen() {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Persoon p : service.getAllPersonen()) {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", p.getId());
			job.add("adres", p.getAdres());
			job.add("woonplaats", p.getWoonplaats());
			job.add("telefoonnummer", p.getTelefoonnummer());
			job.add("bijzonderheden", p.getBijzonderheden());
			job.add("geboortedatum", formatter.format(p.getGeboortedatum()));
			job.add("email", p.getEmail());
			job.add("huisarts", p.getHuisarts());
			job.add("naam", p.getNaam());
			job.add("groep", p.getGroep());
			job.add("rol", p.getRol());

			jab.add(job);
		}

		JsonArray array = jab.build();
		return array.toString();
	}

	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getPersoonById(@PathParam("id") int id) {
		Persoon p = service.getPersoonById(id);
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", p.getId());
		job.add("adres", p.getAdres());
		job.add("woonplaats", p.getWoonplaats());
		job.add("telefoonnummer", p.getTelefoonnummer());
		job.add("bijzonderheden", p.getBijzonderheden());
		job.add("geboortedatum", formatter.format(p.getGeboortedatum()));
		job.add("email", p.getEmail());
		job.add("huisarts", p.getHuisarts());
		job.add("naam", p.getNaam());
		job.add("groep", p.getGroep());
		job.add("rol", p.getRol());

		return job.build().toString();
	}

	@POST
	@Path("/toevoegen")
	@Produces("application/json")
	public String createPersoon(@FormParam("adres") String adres, @FormParam("postcode") String postcode,
			@FormParam("woonplaats") String woonplaats, @FormParam("telefoonnummer") String telefoonnummer,
			@FormParam("bijzonderheden") String bijzonderheden, @FormParam("geboortedatum") Date geboortedatum,
			@FormParam("email") String email, @FormParam("huisarts") String huisarts,
			@FormParam("naam") String naam, @FormParam("betaaltermijn") String betaaltermijn) {
		int id = service.getAllPersonen().size() + 1;
		String groep = null;
		String rol = null;
		Persoon newP = new Persoon(id, adres, woonplaats, Integer.parseInt(telefoonnummer), bijzonderheden, geboortedatum, email, huisarts, naam, groep, rol);
		service.addPersoon(newP);
		return persoonToJson(newP).build().toString();
	}

	private JsonObjectBuilder persoonToJson(Persoon p) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", p.getId());
		job.add("adres", p.getAdres());
		job.add("woonplaats", p.getWoonplaats());
		job.add("telefoonnummer", p.getTelefoonnummer());
		job.add("bijzonderheden", p.getBijzonderheden());
		job.add("geboortedatum", (JsonValue) p.getGeboortedatum());
		job.add("email", p.getEmail());
		job.add("huisarts", p.getHuisarts());
		job.add("naam", p.getNaam());
		job.add("groep", p.getGroep());
		job.add("rol", p.getRol());
		return job;
	}

	@DELETE
	@Path("/delete/{code}")
	public Response deletePersoon(@PathParam("id") int id) {
		Persoon found = null;
		AppService service = ServiceProvider.getAppService();
		for (Persoon p : service.getAllPersonen()) {
			if (p.getId() == id) {
				found = p;
				break;
			}
		}
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			service.deletePersoon(found);
			return Response.ok().build();
		}
	}

}