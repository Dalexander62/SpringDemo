package dogApp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import dogApp.domain.Dog;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //avoids collisions - two apps at the same time
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:dog-schema.sql", "classpath:dog-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class DogControllerIntergrationTest {
	
	@Autowired
	private MockMvc mvc; // class that performs the request 
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception{
		Dog testDog = new Dog(null, "Omnivore", 69, "Rhodesian Ridgeback", "Lion Hunter");
		String testDogAsJSON = this.mapper.writeValueAsString(testDog);
		RequestBuilder req = post("/create").content(testDogAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Dog testCreatedDog= new Dog(2, "Omnivore", 69, "Rhodesian Ridgeback", "Lion Hunter");
		String testCreatedDogAsJSON = this.mapper.writeValueAsString(testCreatedDog);
		ResultMatcher checkStatus = status().isCreated(); 
		ResultMatcher checkBody = content().json(testCreatedDogAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	
	@Test
	void getAllTest() throws Exception {
		
		List<Dog> testDogs = List.of(new Dog(1, "Omnivore", 69, "Rhodesian Ridgeback", "Lion Hunter"));
		String json = this.mapper.writeValueAsString(testDogs);
		
		RequestBuilder req = get("/getAll");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getByIdTest() throws Exception {
		
		Dog testDogs = (new Dog(1, "Omnivore", 69, "Rhodesian Ridgeback", "Lion Hunter"));
		String json = this.mapper.writeValueAsString(testDogs);
		
		RequestBuilder req = get("/get/1");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	
	@Test 
	void getReplaceTest() throws Exception {
		
		Dog testDogs = (new Dog(null, "beans", 70, "Rottweiler", "Working Dog"));
		String json = this.mapper.writeValueAsString(testDogs);
		
		RequestBuilder req = put("/replace/1").content(json).contentType(MediaType.APPLICATION_JSON);
		Dog replaceDog1 = new Dog (1, "beans", 70, "Rottweiler", "Working Dog");
		String replaceDog1AsJson = this.mapper.writeValueAsString(replaceDog1);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(replaceDog1AsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//		mvc.perform(put("/replace/1")).content(json).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	
	void getRemoveTest() throws Exception {
	
	        RequestBuilder req = delete("/remove/1");
	        ResultMatcher checkStatus = status().isNoContent();
	   
	        this.mvc.perform(req).andExpect(checkStatus);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	void testCreate2() throws Exception {
//		Dog testDog = new Dog(null, "Omnivore", 69, "Rhodesian Ridgeback", "Lion Hunter");
//		String testDogAsJSON = this.mapper.writeValueAsString(testDog);
//		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testDogAsJSON);
//
//		Dog testCreatedDog = new Dog(2, "Omnivore", 69, "Rhodesian Ridgeback", "Lion Hunter");
//		String testCreatedDogAsJSON = this.mapper.writeValueAsString(testCreatedDog);
//		ResultMatcher checkStatus = status().isCreated(); 
//		ResultMatcher checkBody = content().json(testCreatedDogAsJSON); 
//
//		
//		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//	}
	

	
	

}
