package com.sandbox.spring.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "HomeControllerTest-context.xml")
public class MockedHomeControllerTest extends BaseControllerTest {

	private static final Logger logger = LoggerFactory
			.getLogger(MockedHomeControllerTest.class);

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
		logger.info("setup is finished");
	}

	@Test
	public void homeController() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(view().name(containsString("home")))
				.andExpect(model().attributeExists("serverTime"))
				.andExpect(model().size(1));		
	}
}