package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

public class ShoppingCarAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IBookService service = new BookServiceImpl();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			Book book = service.findById(id);
			ShoppingCar shoppingCar = (ShoppingCar) request.getSession().getAttribute("shoppingCar");
			if(shoppingCar==null){
				shoppingCar = new ShoppingCar();
				request.getSession().setAttribute("shoppingCar",shoppingCar);
			}
			Line line = new Line();
			line.setBook(book);
			line.setNum(1);
			shoppingCar.add(line);
			
			request.getRequestDispatcher("/user/shopcart.jsp").forward(request, response);
		} catch (BookException e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
