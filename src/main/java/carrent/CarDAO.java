package carrent;

import domain.Car;

import java.util.List;

public interface CarDAO {

    Car addCar(Car car);
    void deleteCar(Car car);
    Car updateCar(Car car);
    List<Car> getAllCars();
    Car getCarByID(Long id);
    List<Car> getAllCarsAvailable();
}