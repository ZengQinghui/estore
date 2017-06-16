package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ShoppingCar;

public class ShoppingCarUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long key = Long.parseLong(request.getParameter("key"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		ShoppingCar shoppingCar = (ShoppingCar)request.getSession().getAttribute("shoppingCar");
		shoppingCar.update(key, num);
		
		response.sendRedirect(request.getContextPath()+"/user/shopcart.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
