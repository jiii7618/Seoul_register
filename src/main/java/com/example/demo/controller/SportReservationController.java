package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SportReservation;
import com.example.demo.repository.SportReservationRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/sports")
@RequiredArgsConstructor
public class SportReservationController {
    private final SportReservationRepository sportReservationRepository;

    @GetMapping(produces = "application/json;charset=UTF-8")
    public Page<SportReservation> getReservations(
            @RequestParam(required = false) String subCategory,
            Pageable pageable) {
        if (subCategory != null && !subCategory.isBlank()) {
            return sportReservationRepository.findBySubCategoryContaining(subCategory, pageable);
        }
        return sportReservationRepository.findAll(pageable);
    }

}
