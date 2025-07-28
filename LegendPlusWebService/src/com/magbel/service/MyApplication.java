package com.magbel.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;




@ApplicationPath("/V1")
public class MyApplication extends Application {
	
//	@Override
//		 public Set<Class<?>> getClasses() {
//		        return new HashSet<Class<?>>(Arrays.asList(Service.class));
//		    }
    
}
