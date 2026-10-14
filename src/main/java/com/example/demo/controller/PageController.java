package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.SportReservation;
import com.example.demo.repository.SportReservationRepository;

@Controller
public class PageController {

    private final SportReservationRepository sportReservationRepository;

    public PageController(SportReservationRepository sportReservationRepository) {
        this.sportReservationRepository = sportReservationRepository;
    }

    @GetMapping({ "/welcome.html", "/welcome", "/" })
    public String welcome() {
        return "welcome"; // templates/welcome.html
    }

    @GetMapping("/tennis")
    public String tennis() {
        return "tennis"; // templates/tennis.html
    }

    @GetMapping("/basketball")
    public String basketball() {
        return "basketball";
    }

    @GetMapping("/footsal")
    public String footsal() {
        return "footsal";
    }

    @GetMapping("/badminton")
    public String badminton() {
        return "badminton";
    }

    @GetMapping("/football")
    public String football() {
        return "football";
    }

    @GetMapping("/add")
    public String requestAddBookingForm() {
        return "addBooking"; // templates/addBooking.html
    }

    @PostMapping("/add")
    public String submitAddNewBooking(@ModelAttribute SportReservation reservation) {
        sportReservationRepository.save(reservation);
        return "redirect:/welcome";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart"; // templates/cart.html
    }
}