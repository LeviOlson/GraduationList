package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Tom Sorteberg - tsorteberg
 * @author Levi Olson - lolson17
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */

/**
 * Servlet implementation class ViewAllCoursesServlet
 */
// Mirror ViewAllItemsServlet.java from 'ShoppingList Online with JPA Servlets JSP 2020.pdf'
// Uses index.jsp as home page.
@WebServlet("/ViewAllCoursesServlet")
public class ViewAllCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCoursesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Local variable declaration and initialization.
		String path = "/graduation-list.jsp";
				
		// Local object declaration and instantiation.
		CoursesHelper dao = new CoursesHelper();
				
		// Method call to set request parameter as a list generated from a context object.
		request.setAttribute("allItems", dao.showAllItems());
				
		// Selection logic to provide exception handling.
		// If database table is empty, redirect to page to add new items.
		if (dao.showAllItems().isEmpty()) {
			path="/index.html";
		}
				
		// Method call to redirect to index.html using request dispatcher.
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
