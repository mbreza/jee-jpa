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

	private Long idCar;
	private String brand;
	private String model;	
	private String description;
	private Boolean available = false;

	private List<Rent> rents = new ArrayList<Rent>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long  getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
