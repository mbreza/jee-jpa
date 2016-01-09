package service;

import carrent.EmpDAO;
import domain.Emp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmpManager implements EmpDAO {

    @PersistenceContext
    EntityManager em;

    public Emp addEmp(Emp emp)
    {
        em.persist(emp);
        em.flush();

        return emp;
    }

    public void deleteEmp(Emp emp)
    {
        em.remove(em.getReference(Emp.class, emp.getIdEmp()));
    }

    public Emp updateEmp(Emp emp)
    {
        return (Emp)em.merge(emp);
    }

    public List<Emp> getAllEmp()
    {
        return em.createNamedQuery("emp.getAll").getResultList();
    }

    public Emp getEmpByID(Long id)
    {
        return em.find(Emp.class, id);
    }
}
