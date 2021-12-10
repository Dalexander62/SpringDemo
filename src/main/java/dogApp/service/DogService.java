package dogApp.service;


import java.util.List;


import dogApp.domain.Dog;

public interface DogService {

	
	
	Dog createDog(Dog dog);

	List<Dog> getAllDog();

	Dog getDog(Integer id);

	Dog replaceDog(Integer id, Dog newDog);

	void removeDog(Integer id);

	List<Dog> getAllDogByType(String type);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private List<Dog> dogs = new ArrayList<>();
//
////	@GetMapping("/helloWorld")
////	public String hello() {
////		return "HELLO, WORLD!";
////	}
//
//	public Dog createDog(Dog dog) {
//		this.dogs.add(dog);
//		Dog created = this.dogs.get(this.dogs.size() - 1);
//		
//		return created;
//	}
//
//	
//	public List<Dog> getAllDogs() {
//		return this.dogs;
//	}
//
//	public Dog getDog(Integer id) {
//		return this.dogs.get(id);
//
//	}
//
//	public Dog replaceDog(Integer id, Dog newDog) {
//		Dog found = this.dogs.set(id, newDog);
//		return found;
//	}
//
//	public void removeDog(@PathVariable Integer id) {
//		this.dogs.remove(id.intValue());

		
	}
