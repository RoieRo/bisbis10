package com.att.tdp.bisbis10.mappers;

import com.att.tdp.bisbis10.dto.*;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Restaurant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper(componentModel = "spring")
@Component
public interface DishMapper {

    Dish createDishToEntity(CreateDishDTO dto);

    Dish updateDishToEntity(UpdateDishDTO dto);

    DishDTO dishToDto(Dish dish);

    }


