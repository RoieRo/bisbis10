package com.att.tdp.bisbis10.mappers;

import com.att.tdp.bisbis10.dto.RatingDTO;
import com.att.tdp.bisbis10.entity.Rating;
import com.att.tdp.bisbis10.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface RatingMapper {

    @Mapping(source = "restaurantId", target = "restaurant.id")
    Rating ratingDtoToEntity(RatingDTO ratingDTO);
}
