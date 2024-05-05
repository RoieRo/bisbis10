package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.CreateDishDTO;
import com.att.tdp.bisbis10.dto.RatingDTO;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Rating;
import com.att.tdp.bisbis10.mappers.RatingMapper;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    private final RatingMapper ratingMapper;

    public RatingService(RatingRepository ratingRepository, RatingMapper ratingMapper){
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    public void addRating(RatingDTO ratingDTO) {
        Rating rating = this.ratingMapper.ratingDtoToEntity(ratingDTO);
        this.ratingRepository.save(rating);
    }
}