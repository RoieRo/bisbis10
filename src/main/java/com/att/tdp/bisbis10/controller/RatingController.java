package com.att.tdp.bisbis10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rating")
public class RatingController {
    @PostMapping()
    public ResponseEntity<Boolean> addRating() {
        return ResponseEntity.ok(true);
    }
}
