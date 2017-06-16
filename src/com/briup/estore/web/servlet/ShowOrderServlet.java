package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IOrderService service = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		
		try {
			if(customer!=null){
				List<Order> list = service.findByCustomerId(customer.getId());
				request.setAttribute("orders", list);
				request.getRequestDispatcher("/user/order.jsp").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		} catch (OrderException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
