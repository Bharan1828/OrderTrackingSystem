package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderViewController {

    @Autowired
    private OrderRepository orderRepo;

    @GetMapping("/order-status")
    public String viewOrder(@RequestParam("orderId") Integer orderId, Model model) {
        Order order = orderRepo.findById(orderId).orElse(null);
        model.addAttribute("order", order);
        return "orderStatus";
    }
}
