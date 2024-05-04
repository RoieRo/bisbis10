package com.att.tdp.bisbis10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @PostMapping()
    public ResponseEntity<Boolean> Order() {
        return ResponseEntity.ok(true);
    }
}
