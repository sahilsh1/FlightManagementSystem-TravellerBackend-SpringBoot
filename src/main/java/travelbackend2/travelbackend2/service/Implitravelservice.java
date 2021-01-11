package travelbackend2.travelbackend2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.ParseException; 
import java.text.SimpleDateFormat; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import travelbackend2.travelbackend2.Dao.TravellerRepository;
import travelbackend2.travelbackend2.Dao.UserRepository;
import travelbackend2.travelbackend2.model.CountryAndDates;
import travelbackend2.travelbackend2.model.Traveller;
import travelbackend2.travelbackend2.model.User;



@Transactional
@Service
public class Implitravelservice {

	@Autowired
	TravellerRepository travellerRepository;
	
	@Autowired
	UserRepository  userRepository;
	
	

	
	public int getDifferenceDays(Date d1, Date d2) {
	    int daysdiff = 0;
	    long diff = d1.getTime() - d2.getTime();
	    long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
	    daysdiff = (int) diffDays;
	    return daysdiff;
	}
	
	public List<Traveller> findByName(String name){
		
		// List<Traveller> t=new ArrayList<Traveller>();
		return  travellerRepository.findByUserUsername(name);
		// return t;
	}
//	
	public boolean addTraveller(Traveller traveller) {
		
		if(userRepository.findByUsername(traveller.getUser().getUsername())==null) 
			  return false;
		
		travellerRepository.save(traveller); 
		return true;
	}


	public boolean signup(User user) {
		if(userRepository.findByUsername(user.getUsername())==null)
		{
			userRepository.save(user);	
			return true;
		}
		else
		{
			return false;
		}
	}

   public boolean Login(User user) {
	   if(userRepository.findUser(user.getUsername(),user.getPassword())==null)
		{
			return  false;
		}
		else
		{
			return true;
		}
	   
     }

   public void updatetraveller(int id, Traveller traveller) {
	
	   String destination = traveller.getFlying_to();
	   
	   Date enddate =traveller. getEnd_date();
	   
	   travellerRepository.update(id,destination,enddate);  
    }
   
    public List<CountryAndDates> findByCountry(String name) {
	// TODO Auto-generated method stub
	           List<Traveller> t =travellerRepository.findById(name);
	           List<CountryAndDates> list = new ArrayList<CountryAndDates>(); 
	           for(Traveller x : t)
	           {
	        	   Date d1 = x.getEnd_date();
	        	   Date d2 = x.getDeparture_date();
	        	   int totalDays=getDifferenceDays(d1,d2);
	        	   String s=x.getName();
	        	   CountryAndDates cd= new CountryAndDates(s,totalDays);
	        	   list.add(cd);
	           }
	           return list; 
    }
    
	public Optional<Traveller> getTravellerById(int id) {
		// TODO Auto-generated method stub
		return travellerRepository.findById(id);
	}
}

