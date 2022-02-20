package com.myapp.spring.service;

public interface SecurityService {
	 boolean isAuthenticated();
	    void autoLogin(String username, String password);
}
