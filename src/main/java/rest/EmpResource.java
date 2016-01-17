package rest;

import carrent.EmpDAO;
import domain.Emp;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Stateless
@Path("/emp")
public class EmpResource {

    @EJB
    private EmpDAO empManager;

    @POST
    @Path("/addEmp")
    public Response addCar(@FormParam("firstName") String firstName,
                                @FormParam("lastName") String lastName,
                                @FormParam("position") String position,
                                @FormParam("pin") int pin,
                                @FormParam("salary") int salary
    		)
    {
        Emp emp = new Emp();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setPosition(position);
        emp.setPin(pin);
        emp.setSalary(salary);

        empManager.addEmp(emp);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/getAllEmp")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Emp> getAllEmp() {
        return empManager.getAllEmp();
    }

    @GET
    @Path("/getEmp/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Emp getEmpByID(@PathParam("id") Long id) {
        return empManager.getEmpByID(id);
    }

    @POST
    @Path("/updateEmp")
    public Response updateCar(@FormParam("idEmp") Long idEmp,
                                   @FormParam("firstName") String firstName,
                                   @FormParam("lastName") String lastName,
                                   @FormParam("position") String position,
                                   @FormParam("pin") int pin,
                                   @FormParam("salary") int salary)
    {
        Emp emp = new Emp();
        emp.setIdEmp(idEmp);
        emp.setFirstName(firstName);
        emp.setLastName( lastName);
        emp.setPosition(position);
        emp.setPin(pin);
        emp.setSalary(salary);

        empManager.updateEmp(emp);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/deleteEmp")
    public Response deleteCar(@FormParam("idEmp") Long idEmp)
    {
        Emp emp = new Emp();
        emp.setIdEmp(idEmp);

        empManager.deleteEmp(emp);

        return Response.status(Response.Status.OK).build();
    }
}