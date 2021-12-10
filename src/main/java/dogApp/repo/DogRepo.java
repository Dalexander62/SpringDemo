package dogApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dogApp.domain.Dog;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer>{

	List<Dog> findByTypeIgnoreCase(String type);

	List<Dog> findByDiet(String diet);
	
	List<Dog> findByWeight(Integer weight);
	
	List<Dog> findByBreed(String breed);

	
	
}
