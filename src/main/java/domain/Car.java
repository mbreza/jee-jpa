package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Car")
@NamedQueries({
		@NamedQuery(name = "car.getAll", query = "Select c from Car c"),
		@NamedQuery(name = "car.getByID", query = "Select c from Car c where c.idCar = :idCar"),
		@NamedQuery(name = "car.isAvailable", query = "Select c from Car c where c.available = true") 
		})
public class Car {

	private int idCar;
	private String Brand;
	private String Model;	
	private String Description;
	private Boolean Available = false;

	private List<Rent> rents = new ArrayList<Rent>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public Boolean getAvailable() {
		return Available;
	}

	public void setAvailable(Boolean available) {
		Available = available;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "car")
	@JsonIgnore
	public List<Rent> getRents() {
		return rents;
	}
	
	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
}
