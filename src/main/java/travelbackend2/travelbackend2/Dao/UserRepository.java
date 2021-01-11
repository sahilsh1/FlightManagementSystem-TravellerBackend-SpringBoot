package travelbackend2.travelbackend2.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import travelbackend2.travelbackend2.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, String>{

//	boolean findByUsername(boolean b);
//	
	
       //	 @Query("SELECT t.USER_USERNAME FROM TRAVELLER t where t.USER_USERNAME  = ?1") 
     public User findByUsername(String name);

     @Query("SELECT t FROM User t where t.username= ?1 and t.password =?2") 
	  public User findUser(String username,String password);

	//public Object findByUserUsername(String username);

}