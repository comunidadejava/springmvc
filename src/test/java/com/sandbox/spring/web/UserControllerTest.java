package com.sandbox.spring.web;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class UserControllerTest extends BaseControllerTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserControllerTest.class);
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/");
//		viewResolver.setSuffix(".jsp");
//		this.mockMvc = standaloneSetup(new UserController()).setViewResolvers(viewResolver).build();
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void createUserSuccess() throws Exception {
		this.mockMvc.perform(
				post("/users/create")
				.param("name", "tiago")
				.param("lastName", "tiago")
				.param("age", "31")
				.param("accountId", "222"))
				.andDo(print())
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/users/create"));
	}
	
	@Test
	public void userFormGet()  throws Exception {
		this.mockMvc.perform(get("/users/create"))
		.andExpect(view().name(containsString("createUser")))
		.andExpect(model().attributeExists("user"))
		.andExpect(model().size(1));
	}
	
	@Test
	public void userGetById()  throws Exception {
		
		this.mockMvc.perform(get("/users/1"))
		.andDo(print())
		.andExpect(view().name(containsString("user")))
		.andExpect(model().attribute("user", hasProperty("name", equalTo("tiago"))))		
		.andExpect(model().size(1));
	}
}
