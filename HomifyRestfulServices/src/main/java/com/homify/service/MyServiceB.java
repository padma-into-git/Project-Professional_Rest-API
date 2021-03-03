package com.homify.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("serviceB")
@Component("serviceB")
public class MyServiceB implements MyServiceInterface {
    @Override
    public void myMethod() {
        System.out.print("Do B");
    }
}