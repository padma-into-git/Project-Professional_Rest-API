package com.homify.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("serviceA")
@Component("serviceA")
public class MyServiceA implements MyServiceInterface {
    @Override
    public void myMethod() {
        System.out.print("Do A");
    }
}