package rest;

import carrent.*;
import domain.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Stateless
@Path("rent")
public class RentResource {
	@EJB
	private CarDAO carManager;
	@EJB
	private EmpDAO empManager;
	@EJB
	private RentDAO rentManager;

	@POST
	@Path("/addRent")
	public Response addRent(
			@FormParam("carID") Long carID,
			@FormParam("empID") Long empID,
			@FormParam("price") double price,
			@FormParam("dor") Date dor) {
		Rent rent = new Rent();
		rent.setCar(carManager.getCarByID(carID));
		rent.setEmp(empManager.getEmpByID(empID));
		rent.setPrice(price);
		rent.setDor(dor);
		rentManager.addRent(rent);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/getAllRent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rent> getAllRent() {
		return rentManager.getAllRent();
	}

	@GET
	@Path("/getRent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Rent getRentByID(@PathParam("id") Long id) {
		return rentManager.getRentByID(id);
	}

	@POST
	@Path("/updateRent")
	public Response updateRent(@FormParam("idRent") long idRent,
			@FormParam("car") String car,
			@FormParam("emp") String emp,
			@FormParam("price") double price, @FormParam("dor") Date dor) {
		Long carID = Long.parseLong(car.substring(0,car.indexOf('.')));
		Long empID = Long.parseLong(emp.substring(0,emp.indexOf('.')));
		Rent rent = rentManager.getRentByID(idRent);
		rent.setCar(carManager.getCarByID(carID));
		rent.setEmp(empManager.getEmpByID(empID));
		rent.setPrice(price);
		rent.setDor(dor);
		rentManager.updateRent(rent);
		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Path("/deleteRent")
	public Response deleteRent(@FormParam("idRent") long idRent) {
		Rent rent = new Rent();
		rent.setIdRent(idRent);
		rentManager.deleteRent(rent);
		return Response.status(Response.Status.OK).build();
	}
}
