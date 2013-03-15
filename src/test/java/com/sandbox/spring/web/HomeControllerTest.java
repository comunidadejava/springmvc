package com.sandbox.spring.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HomeControllerTest {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeControllerTest.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;
	 
	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	
	
	private MockHttpServletRequest request; // http request Mock Object
	private MockHttpServletResponse response; // http responce Mock Object

	@Before
	public void setUp() throws Exception {

		logger.info("INIT Setup");

		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		logger.info("Setup END");
	}

	@Test
	public void testContext() { // check application Context
		logger.info("Application Context Test!");
		Assert.assertNotNull(applicationContext);
	}

	@Test
	public void testHomeController() throws Exception {

		this.request.setRequestURI("/"); // controller uri.
		this.request.setMethod("GET"); // http mehtod eg GET POST.
		
		final Object handler = this.handlerMapping.getHandler(this.request).getHandler();
		final ModelAndView mav = handlerAdapter.handle(this.request, this.response, handler);
		logger.info("Controller call");

		Assert.assertEquals(mav.getViewName(), "home");
	}

}
