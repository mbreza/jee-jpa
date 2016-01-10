package carrent;

import domain.*;

import java.util.List;

public interface RentDAO {

    Rent addRent(Rent rent);
    void deleteRent(Rent rent);
    Rent updateRent(Rent rent);
    List<Rent> getAllRent();
    Rent getRentByID(Long id);
    List<Rent> getRentByCarID(Car car);
    List<Rent> getRentByEmpID(Emp emp);

}
