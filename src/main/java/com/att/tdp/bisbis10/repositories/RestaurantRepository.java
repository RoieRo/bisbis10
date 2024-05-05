package com.att.tdp.bisbis10.repositories;


import com.att.tdp.bisbis10.dto.RestaurantListDTO;
import com.att.tdp.bisbis10.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
// the params of Jpa are the object and the primary key
public interface RestaurantRepository extends JpaRepository<Restaurant, Long > {

    @Query("SELECT r FROM Restaurant r JOIN r.cuisines c WHERE c = :cuisine")
    List<Restaurant> findByCuisine(@Param("cuisine") String cuisine);

}
