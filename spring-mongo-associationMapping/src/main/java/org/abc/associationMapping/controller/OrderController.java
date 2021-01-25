package org.abc.associationMapping.controller;

import java.util.List;

import org.abc.associationMapping.model.User;
import org.abc.associationMapping.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderService")
public class OrderController {

	@Autowired
	private OrderRepo repo;

	@PostMapping("/placedOrder")
	public String placeOrder(@RequestBody User user) {
		repo.save(user);
		return "Order has been placed successfully!!";
	}

	@GetMapping("/getUserByName/{name}")
	public List<User> getUserbyName(@PathVariable String name) {
		return repo.findByName(name);
	}

	@GetMapping("/getUserByAddress/{city}")
	public List<User> getUserbyAddress(@PathVariable String city) {
		return repo.findByCity(city);
	}

}