package com.homify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface MyServiceInterface {
	@Autowired
	void myMethod();
}
