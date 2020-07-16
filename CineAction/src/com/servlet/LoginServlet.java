package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.dao.AuthenticationDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameterMap().size() == 0) {
			request.getRequestDispatcher("/WEB-INF/Resources/login.jsp").forward(request, response);
		} else {
			String name = request.getParameter("user");
			String pass = request.getParameter("pass");

			User user = new User(name, pass);
			boolean isRegistered = AuthenticationDao.checkAlreadyRegistered(user);

			System.out.println("isregistered" + isRegistered);

			if (isRegistered == true) {
				request.getSession().setAttribute("user", name);
				response.sendRedirect("index.jsp");
			} else {
				String errorMsg = "Username/password is incorrect!";
				request.setAttribute("error", errorMsg);
				request.getRequestDispatcher("/WEB-INF/Resources/login.jsp").forward(request, response);
			}

		}
	}

}
