package com.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteServiceImp implements IRemoteService{

    private final Logger logger
            = LoggerFactory.getLogger(RemoteServiceImp.class);

    @Override
    public String HelloWorld(String name) {
        logger.info("Service2 being used");
        if(Thread.currentThread().isInterrupted())
            System.out.println("Cancelled");
        return "Hello world : " + name;
    }

}
