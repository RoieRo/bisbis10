package com.att.tdp.bisbis10.repositories;


import com.att.tdp.bisbis10.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// the params of Jpa are the object and the primary key
public interface RestaurantRepository extends JpaRepository<Restaurant, Long > {
}
