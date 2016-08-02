package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>用户登录</h1>");
		// action应该这样写：/web应用名/Servlet的url
		out.println("<form action='/counter/LoginCl' method='post'>");
		out.println("用户id：<input type='text' name='id'/><br/>");
		out.println("密    码：<input type='password' name='password'/><br/>");
		out.println("<input type='submit' value='登录'/><br/>");
		out.println("</form>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
