package com.pavan.couponservice;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pavan.demoservice.controllers.DemoController;
//import org.junit.jupiter.api.BeforeEach;

import org.springframework.http.MediaType;

@WebMvcTest
public class TestEmployeeRESTController {

	//@Autowired
	private MockMvc mvc;

	//@BeforeEach
	void setUp(WebApplicationContext wac) throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac)
						.alwaysExpect(status().isOk())
						.alwaysExpect(content().contentType(MediaType.APPLICATION_JSON))
						.alwaysDo(print())
						.build();
	}
	
	//@Test
	public void abc() {
		try {
			
			System.out.println(mvc);
			mvc.perform(MockMvcRequestBuilders.get("/demo/fetch"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
