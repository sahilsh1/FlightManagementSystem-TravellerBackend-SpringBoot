package travelbackend2.travelbackend2.consumer;



import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import travelbackend2.travelbackend2.model.Traveller;
import travelbackend2.travelbackend2.rabbitmq.config.RabbitMqConfig;
import travelbackend2.travelbackend2.service.Implitravelservice;




@Component
public class Consumer {
	   
	
	   @Autowired
	   Implitravelservice itravelservice;
	  
	  
	  @RabbitListener(queues=RabbitMqConfig.QUEUE) 
	  public void consumeTraveller(Traveller traveller) { 
		  boolean x=itravelservice.addTraveller(traveller);
		  System.out.println(x);
	  }
}



