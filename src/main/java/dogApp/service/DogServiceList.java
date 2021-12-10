package dogApp.service;

import java.util.ArrayList;
import java.util.List;

import dogApp.domain.Dog;


public class DogServiceList implements DogService{
	
	
	
		private List<Dog> dogs = new ArrayList<>();

		@Override
		public Dog createDog(Dog dog) {
			this.dogs.add(dog);
			Dog created = this.dogs.get(this.dogs.size() - 1);
			return created;
		}

		@Override
		public List<Dog> getAllDog() {
			return this.dogs;
		}

		@Override
		public Dog getDog(Integer id) {
			return this.dogs.get(id);
		}

		@Override
		public Dog replaceDog(Integer id, Dog newDog) {
			Dog found = this.dogs.set(id, newDog);

			return found;
		}

		@Override
		public void removeDog(Integer id) {
			this.dogs.remove(id.intValue());
		}

		@Override
		public List<Dog> getAllDogByType(String type) {
			
			return null;
		}

	
	}

