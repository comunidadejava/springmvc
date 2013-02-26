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
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HomeControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private HomeController homeController;

	private MockHttpServletRequest request; // http request Mock Object
	private MockHttpServletResponse response; // http responce Mock Object
	private AnnotationMethodHandlerAdapter handlerAdapter; // handles annotation
															// controller
															// methods

	@Before
	public void setUp() throws Exception {

		logger.info("INIT Setup");

		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		handlerAdapter = new AnnotationMethodHandlerAdapter();

		logger.info("Setup END");
	}

	@Test
	public void testContext() { // check application Context
		logger.info("Application Context Test!");
		Assert.assertNotNull(applicationContext);
	}

	@Test
	public void testHomeController() throws Exception {

		request.setRequestURI("/"); // controller uri.
		request.setMethod("GET"); // http mehtod eg GET POST.

		final ModelAndView mav = handlerAdapter.handle(request, response, homeController);
		logger.info("Controller call");

		Assert.assertEquals(mav.getViewName(), "home");

	}

}
