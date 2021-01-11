package travelbackend2.travelbackend2.Dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import travelbackend2.travelbackend2.model.Traveller;



@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Integer>{

   List<Traveller> findByUserUsername(String username);

   @Modifying
   @Query("update Traveller t set t.flying_to = ?2, t.end_date = ?3 where t.id = ?1")
   void update(int id, String destination, Date enddate);
   @Modifying
//   @Query("UPDATE Traveller t SET t.flying_to = :destination,t.end_date = enddate WHERE t.id = :id")
//   int update(@Param("id") int id, @Param("address") String address);
   @Query("from Traveller t where t.flying_to = ?1")
   List<Traveller> findById(String name);
	
}
