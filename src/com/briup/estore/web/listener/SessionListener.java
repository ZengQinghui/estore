package com.briup.estore.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.estore.bean.ShoppingCar;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("shoppingCar", new ShoppingCar());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
