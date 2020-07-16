package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MovieDao;
import com.dao.DirectorDao;
import com.dao.CategoryDao;
import com.entity.Movie;

/**
 * Servlet implementation class FiltersServlet
 */
@WebServlet("/movies")
public class FiltersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FiltersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> filteredParameters = new LinkedHashMap<>();
		filteredParameters.put("name", "");
		filteredParameters.put("directorId", "");
		filteredParameters.put("categoryId", "");
		filteredParameters.put("year", "");

		Map<String, String[]> parameters = request.getParameterMap();

		parameters.forEach((k, v) -> {
			System.out.println("parameter" + " " + k);
			if (filteredParameters.keySet().contains(k)) {
				switch (k) {
				case "directorId": {
					if (v[0].equals("")) {
						filteredParameters.put(k, v[0]);
					} else {
						int id = new DirectorDao().getDirectorId(v[0]);
						System.out.println("director id" + " " + id);
						filteredParameters.put(k, Integer.toString(id));
					}

					break;
				}
				case "categoryId": {
					if (v[0].equals("")) {
						filteredParameters.put(k, v[0]);
					} else {
						int id = new CategoryDao().getCategoryId(v[0]);
						System.out.println("category id" + " " + id);
						filteredParameters.put(k, Integer.toString(id));
					}
					break;
				}
				default:
					filteredParameters.put(k, v[0]);

				}

			}
		});

		@SuppressWarnings("unchecked")
		ArrayList<Movie> movies = new MovieDao().getMoviesByParameter(filteredParameters);
		request.setAttribute("movies_filter", movies);
		request.getRequestDispatcher("/WEB-INF/Resources/movies.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
