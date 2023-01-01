package com.cnp.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnp.dao.CouponDao;
import com.cnp.dao.ProductDao;
import com.cnp.model.Coupon;
import com.cnp.model.Product;
@WebServlet("/products")
	public class ProductController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	CouponDao couponDao = new CouponDao();
	ProductDao productDao = new ProductDao();
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String couponCode = request.getParameter("couponCode");
			Coupon coupon = couponDao.findByCode(couponCode);
			Product product = new Product();
			product.setName(name);
			product.setDescription(description);
			product.setPrice(new BigDecimal(price));
			productDao.save(product);

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<b>Produc Created</b>");
			out.print("<br/><a href='/candpapp'>Home</a>");
		}

	}


