package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICustomerService service = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("userid");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String street1 = request.getParameter("street1");
//		String street2 = request.getParameter("street2");
		String zip = request.getParameter("zip");
//		String homephone = request.getParameter("homephone");
//		String officephone = request.getParameter("officephone");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setZip(zip);
		customer.setAddress(country+province+city+street1);
		customer.setTelephone(cellphone);
		customer.setEmail(email);
		
		try {
			service.register(customer);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (CustomerException e) {
			request.setAttribute("remsg", e.getMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
