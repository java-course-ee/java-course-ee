/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.test.jquery;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class NamesServlet extends HttpServlet {
	
	private static List<Name> names = new ArrayList<Name>();

	@Override
	public void init() throws ServletException {
		super.init();
		
		names.add(new Name(1L, "Ivan", "Ivan"));
		names.add(new Name(2L, "Ivanio", "Ivanio"));
		names.add(new Name(3L, "Alex", "Alex"));
		names.add(new Name(4L, "Alexander", "Alexander"));
	}

	/**
	 * Processes requests for both HTTP
	 * <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String term =request.getParameter("term");


        System.out.println("term = " + term);

        List<Name> toClient = new ArrayList<Name>();
		for (Name n: names) {
			if (n.getValue().toLowerCase().contains(term.toLowerCase())) {
				toClient.add(n);
			}
		}

		Gson gson = new Gson();
		
		PrintWriter out = response.getWriter();
		try {
			out.print(gson.toJson(toClient));
		} finally {			
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
