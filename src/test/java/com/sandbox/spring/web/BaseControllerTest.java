package com.sandbox.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration
public class BaseControllerTest {
	
	@Autowired
	protected WebApplicationContext wac;
}
