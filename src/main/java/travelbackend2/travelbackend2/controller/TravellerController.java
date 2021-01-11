package travelbackend2.travelbackend2.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import travelbackend2.travelbackend2.model.CountryAndDates;
import travelbackend2.travelbackend2.model.Traveller;
import travelbackend2.travelbackend2.model.User;
import travelbackend2.travelbackend2.service.Implitravelservice;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TravellerController {

   @Autowired
   private RabbitTemplate template;
   
   
   
   
   @Autowired
   Implitravelservice itravelservice;
	
   @GetMapping("/trvallerbyid/{id}")
   private Optional<Traveller> getTravellerById(@PathVariable("id") int id) {
	   
	   return itravelservice.getTravellerById(id);
   }
   
   @GetMapping("/byCountry/{flying_to}")
   private List<CountryAndDates> getTravellerByCountry(@PathVariable("flying_to") String name) {
		
		return itravelservice.findByCountry(name);
	}
	
	
   @GetMapping("/{username}/flightlist")
   private List<Traveller> getTravellerByName(@PathVariable("username") String name) {
		
		return itravelservice.findByName(name);
	}
	
	
	@PostMapping("/{username}/addtraveller")
	public boolean addTraveller(@PathVariable("username") String username,@RequestBody Traveller traveller)
	{
		traveller.setUser(new User(username,""));
		return itravelservice.addTraveller(traveller);
	}
	@PostMapping("/signup")
	public boolean signup(@RequestBody User user)
	{

		return itravelservice.signup(user);

	}
	@PostMapping("/login")
	public boolean login(@RequestBody User user)
	{

		return itravelservice.Login(user);

	}	
	
	@PutMapping("/update/{id}")
	public void  Updatetravel(@PathVariable("id") int id,@RequestBody Traveller traveller)
	{
		itravelservice.updatetraveller(id,traveller);

	}
	
}

