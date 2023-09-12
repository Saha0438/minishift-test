package com.pavan.demoservice.controllers;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@GetMapping("/fetch")
	public Product fetch() {
		Product product = new Product();
		product.setName("hi pavan 123");
		
		//Config config = new Config();
		//config.useSingleServer()
		 // .setAddress("redis://127.0.0.1:6379");

		//RedissonClient client = Redisson.create(config);
		
		System.out.println("redis got connected");
		
		return product;
	}
}
