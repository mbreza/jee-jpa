package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "rent.getAll", query = "Select r from Rent r"),
        @NamedQuery(name = "rent.getByID", query = "Select r from Rent r where r.idRent = :idRent"),
        @NamedQuery(name = "rent.getByIdCar", query = "Select r from Rent r where r.car = :idCar"),
        @NamedQuery(name = "rent.getByIdEmp", query = "Select r from Rent r where r.emp = :idEmp"),
})


public class Rent {

	
	private Long idRent;
    private Date doo;       //date of order
    private double price;


    private Car car;
    private Emp emp;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getIdRent() {
        return idRent;
    }
    public void setIdRent(Long idRent) {
        this.idRent = idRent;
    }

    @Temporal(TemporalType.DATE)
    public Date getDoo() {
        return doo;
    }
    public void setDoo(Date doo) {
        this.doo = doo;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "idCar")
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name = "idEmp")
    public Emp getEmp() {
        return emp;
    }
    public void setEmp(Emp emp) {
        this.emp = emp;
    }
	
}
