package service;

import carrent.RentDAO;
import domain.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class RentManager implements RentDAO {

	@PersistenceContext
	EntityManager em;

	public Rent addRent(Rent rent) {
		em.persist(rent);
		em.flush();

		return rent;
	}

	public void deleteRent(Rent rent) {
		em.remove(em.getReference(Rent.class, rent.getIdRent()));
	}

	public Rent updateRent(Rent rent) {
		return (Rent) em.merge(rent);
	}

	public List<Rent> getAllRent() {
		return em.createNamedQuery("rent.getAll").getResultList();
	}

	public Rent getRentByID(Long id) {
		return em.find(Rent.class, id);
	}

	public List<Rent> getRentByCarID(Car car) {
		return em.createNamedQuery("rent.getByIdCar")
				.setParameter("idCar", car.getIdCar()).getResultList();
	}

	public List<Rent> getRentByEmpID(Emp emp) {
		return em.createNamedQuery("rent.getByIdEmp")
				.setParameter("idEmp", emp.getIdEmp()).getResultList();
	}
}