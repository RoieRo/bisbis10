package com.att.tdp.bisbis10.mappers;

import com.att.tdp.bisbis10.dto.CreateRestaurantDTO;
import com.att.tdp.bisbis10.dto.RestaurantDTO;
import com.att.tdp.bisbis10.dto.RestaurantListDTO;
import com.att.tdp.bisbis10.dto.UpdateRestaurantDTO;
import com.att.tdp.bisbis10.entity.Restaurant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public interface RestaurantMapper {

    RestaurantListDTO restaurantToListDto(Restaurant restaurant);

    Restaurant createRestaurantToEntity(CreateRestaurantDTO dto);

    Restaurant updateRestaurantToEntity(UpdateRestaurantDTO dto);

    RestaurantDTO restaurantToDto(Restaurant restaurant);

    default Set<String> mapCuisines(Set<String> cuisines) {
        return cuisines;
    }
}

