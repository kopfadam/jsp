package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AuthenticationDao;
import com.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameterMap().size() == 0) {
			request.getRequestDispatcher("/WEB-INF/Resources/register.jsp").forward(request, response);
		} else {
			String name = request.getParameter("user");
			String pass = request.getParameter("pass");
			
			User user = new User(name, pass);
			boolean isRegistered = AuthenticationDao.checkAlreadyRegistered(user);

			System.out.println("isregistered" + isRegistered);

			if (isRegistered) {
				System.out.println("Already registered");
				response.sendRedirect("index.jsp");
			} else {
				int isSuccess = AuthenticationDao.register(user);

				if (isSuccess == 1) {
					System.out.println("Successfully registered!");
					response.sendRedirect("index.jsp");

				} else {
					System.out.println("There is an error! Please try again.");
					request.getRequestDispatcher("/WEB-INF/Resources/register.jsp").forward(request, response);
				}

			}

		}
	}

}
