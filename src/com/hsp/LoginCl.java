package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 这里接收密码
		String passwd = request.getParameter("password");
		
		if ("123".equals(passwd)) {
			// 合法
			// 向servletContext中添加属性
			// 1、先取出
		    String nums = (String) this.getServletContext().getAttribute("nums");
			
			// 如果有，则取出+1
			this.getServletContext().setAttribute("nums", (Integer.parseInt(nums) + 1) + "");
		
			
			// 3、再更新
			
//			this.getServletContext().setAttribute("nums", "1");
//			request.getRequestDispatcher("/Manage")
//			.forward(request, response);
			response.sendRedirect("/counter/Manage");
		} else {
			// 非法
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
