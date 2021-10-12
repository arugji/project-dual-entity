package com.dualentity.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dualentity.app.helper.ListHelper;

/**
 * arugji CIS175 fall 2021 Oct 5
 */
@WebServlet("/SaveCompanyData")
public class SaveCompanyData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListHelper lh = new ListHelper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveCompanyData() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String candyId = request.getParameter("candyId");
		String name = request.getParameter("name");
		lh.insertCompanyDetails(name, Long.parseLong(candyId));
		getServletContext().getRequestDispatcher("/ViewAllNameServlet").forward(request, response);
	}

}
