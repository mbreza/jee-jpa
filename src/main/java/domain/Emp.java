package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
		@NamedQuery(name = "emp.getAll", query = "Select e from Emp e"),
		@NamedQuery(name = "emp.getByID", query = "Select e from Emp e where e.idEmp = :idEmp") })
public class Emp {

	private Long idEmp;
	private String firstName;
	private String lastName;
	private String position;
	private int pin;
	private int salary;

	private List<Rent> rents = new ArrayList<Rent>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long  getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(Long idEmp) {
		this.idEmp = idEmp;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emp")
	@JsonIgnore
	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
}
