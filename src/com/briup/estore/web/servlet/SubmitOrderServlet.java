package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IOrderService service = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		ShoppingCar shoppingCar = (ShoppingCar) session.getAttribute("shoppingCar");
		Order order = new Order();
		order.setCustomer(customer);
		order.setCost(shoppingCar.getCost());
		order.setLines(shoppingCar.getLines().values());
		order.setOrderDate(new Date());
		try {
			service.confirmOrder(order);
			shoppingCar.clear();
			session.setAttribute("msg", "订单提交成功");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (OrderException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
