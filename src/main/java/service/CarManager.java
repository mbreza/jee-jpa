package service;

import carrent.CarDAO;
import domain.Car;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class CarManager implements CarDAO {

    @PersistenceContext
    EntityManager em;

    public Car addCar(Car car)
    {
        em.persist(car);
        em.flush();

        return car;
    }

    public void deleteCar(Car car)
    {
        em.remove(em.getReference(Car.class, car.getIdCar()));
    }

    public Car updateCar(Car car)
    {
        return em.merge(car);
    }

    public List<Car> getAllCarsAvailable()
    {
        return em.createNamedQuery("car.getAvailable").getResultList();
    }

    public List<Car> getAllCars()
    {
        return em.createNamedQuery("car.getAll").getResultList();
    }

    public Car getCarByID(Long id)
    {
        return em.find(Car.class, id);
    }
}
