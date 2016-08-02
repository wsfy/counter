package com.hsp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		
		System.out.println("initServlet destroy()被调用。。");
		// Tomcat服务器启动的时候把数据从record.txt读进来，则服务器关闭的时候则要把值写回去。把ServletContext值重新保存到文件。
		// 从record.txt文件中，读取浏览量。
		// 1、首先得到该文件的真实路径
		String filePath = this.getServletContext().getRealPath("record.txt");
		// 2、打开文件
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			// 为了读取我们转为BufferedReader
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// 从ServletContect中读取访问量
			String nums = (String) this.getServletContext().getAttribute("nums");
			// 重新写回文件。
			bufferedWriter.write(nums);
			// 一定要关闭流。bufferedReader流来自于fileReader流。
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭。。。
		}
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		// Tomcat服务器先运行这个类文件。从record.txt文件中，读取浏览量。
		// 1、首先得到该文件的真实路径。
		String filePath = this.getServletContext().getRealPath("record.text");
		// 2、打开文件
		try {
			FileReader fileReader = new FileReader(filePath);
			// 为了读取我们转为BufferedReader，用BufferedReader读一行效率比较高。
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String nums = bufferedReader.readLine();
			// 把nums添加到ServletContext
			System.out.println("*********************nums=" + nums);
			this.getServletContext().setAttribute("nums", nums);
			// 一定要关闭流。流不关的话容易报空。
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
