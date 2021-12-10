package dogApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dogApp.domain.Dog;
import dogApp.repo.DogRepo;

@Service
public class DogServiceDB implements DogService {

	private DogRepo repo;

	@Autowired
	public DogServiceDB(DogRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Dog createDog(Dog dog) {
		Dog created = this.repo.save(dog);
		return created;
	}

	public String testMeTestMe() {
		return "Yo";
	}

	@Override
	public List<Dog> getAllDog() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Dog getDog(Integer id) {
		// TODO Auto-generated method stub
		Optional<Dog> found = this.repo.findById(id);
		return found.get();

	}

	@Override
	public List<Dog> getAllDogByType(String type) {
		List<Dog> found = this.repo.findByTypeIgnoreCase(type);
		return found;
	}

	@Override
	public Dog replaceDog(Integer id, Dog newDog) {
		Dog existing = this.repo.findById(id).get();

		existing.setDiet(newDog.getDiet());
		existing.setWeight(newDog.getWeight());
		existing.setBreed(newDog.getBreed());
		existing.setType(newDog.getType());

		Dog updated = this.repo.save(existing);
		return updated;
	}

	@Override
	public void removeDog(Integer id) {
		this.repo.deleteById(id);
	}

}
