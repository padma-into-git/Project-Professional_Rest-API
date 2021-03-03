package com.homify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyBusinessLogic {

    @Autowired
    @Qualifier("serviceA")
    private MyServiceInterface myServiceInterface;

    public void businessLogic() {
        System.out.println("Do something");
        myServiceInterface.myMethod();

        System.out.println("Done");
    }
    
    public static void main(String args[]) {
    	MyBusinessLogic bl = new MyBusinessLogic();
    	bl.businessLogic();
    }
}


