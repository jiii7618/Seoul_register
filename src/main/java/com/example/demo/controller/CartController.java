package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CartItem;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private static final String KEY = "cart";

    @SuppressWarnings("unchecked")
    private List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute(KEY);
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute(KEY, cart);
        }
        return cart;
    }

    @GetMapping
    public List<CartItem> list(HttpSession session) {
        return getCart(session);
    }

    @PostMapping
    public List<CartItem> add(@RequestBody CartItem item, HttpSession session) {
        List<CartItem> cart = getCart(session);
        if (cart.stream().noneMatch(c -> c.serviceId().equals(item.serviceId()))) {
            cart.add(item);
        }
        return cart;
    }

    @DeleteMapping("/{serviceId}")
    public List<CartItem> remove(@PathVariable String serviceId, HttpSession session) {
        List<CartItem> cart = getCart(session);
        cart.removeIf(c -> c.serviceId().equals(serviceId));
        return cart;
    }
}
