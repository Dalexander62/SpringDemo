package dogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dogApp.domain.Dog;
import dogApp.service.DogService;



@RestController

public class DogsController {

	private DogService service;
	
//	private List<Dog> dogs = new ArrayList<>();
	
	@Autowired
	
	
	public DogsController(DogService service) {
	super();
	this.service = service;
}

	@GetMapping("/helloWorld")
	public String hello() {
		return "HELLO, WORLD!";
	}

	@PostMapping("/create")
	public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
//		this.dogs.add(dog);
		Dog created = this.service.createDog(dog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Dog>> getAllDogs() {
		return ResponseEntity.ok(this.service.getAllDog());
	
//	public List<Dog> getAllDogs() {
//		return this.dogs;
	}

	@GetMapping("/get/{id}")
	public Dog getById(@PathVariable Integer id) {
		return this.service.getDog(id);
		
//		System.out.println("ID: " + id);
//		return this.dogs.get(0);
//
//				dogs.get(id);
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Dog> replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.service.replaceDog(id, newDog);
		
		//		Dog body = this.dogs.set(id, newDog);
//		System.out.println("ID: " + id);
//		System.out.println("DOG: " + newDog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeDog(@PathVariable Integer id) {

		this.service.removeDog(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
