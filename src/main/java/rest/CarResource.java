package rest;

import carrent.CarDAO;
import domain.Car;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Stateless
@Path("/car")
public class CarResource {

    @EJB
    private CarDAO carManager;

    @POST
    @Path("/addCar")
    public Response addCar(@FormParam("brand") String brand,
                                @FormParam("model") String model,
                                @FormParam("description") String description)
    {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setDescription(description);

        carManager.addCar(car);

        return Response.status(Response.Status.CREATED).build();
       
    }

    @GET
    @Path("/getAllCars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        return carManager.getAllCars();
    }

    @GET
    @Path("/getCar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarByID(@PathParam("id") Long id) {
        return carManager.getCarByID(id);
    }

    @POST
    @Path("/updateCar")
    public Response updateCar(@FormParam("idCar") Long idCar,
                                   @FormParam("brand") String brand,
                                   @FormParam("model") String model,
                                   @FormParam("description") String description)
    {
        Car car = new Car();
        car.setIdCar(idCar);
        car.setBrand(brand);
        car.setModel(model);
        car.setDescription(description);
        car.setAvailable(Boolean.FALSE);

        carManager.updateCar(car);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/deleteCar")
    public Response deleteCar(@FormParam("idCar") Long idCar)
    {
        Car car = new Car();
        car.setIdCar(idCar);

        carManager.deleteCar(car);

        return Response.status(Response.Status.OK).build();
    }
}