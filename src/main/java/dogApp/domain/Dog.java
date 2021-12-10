package dogApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String diet;
	
	private Integer weight;
	
	private String breed;

	private String type;

	public Dog() {
		super();

	}
	
	

	public Dog(Integer id, String diet, Integer weight, String breed, String type) {
		super();
		this.id = id;
		this.diet = diet;
		this.weight = weight;
		this.breed = breed;
		this.type = type;
	}



	public Dog(String diet, Integer weight, String breed, String type) {
		super();
		this.diet = diet;
		this.weight = weight;
		this.breed = breed;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	
	@Override
	public String toString() {
		return "Dog [id=" + id + ", diet=" + diet + ", weight=" + weight + ", breed=" + breed + ", type=" + type + "]";
	}



	public String getType() {
		
		return type;
	}

	public void setType(String type) {
		this.type = type;
		
		
	}

}
