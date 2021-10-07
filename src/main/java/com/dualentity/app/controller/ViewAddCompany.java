package com.dualentity.app.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dualentity.app.entity.CandyDetails;
import com.dualentity.app.util.EntityManagerUtil;

/**
 * arugji 
 * CIS175 fall 2021
 * Oct 5
 */
@WebServlet("/ViewAddCompany")
public class ViewAddCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAddCompany() {
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
		String candyId = request.getParameter("id");
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		CandyDetails clr = entityManager.find(CandyDetails.class, Long.parseLong(candyId));
		request.setAttribute("name", clr.getName());
		request.setAttribute("candyId", candyId);
		entityManager.getTransaction().commit();
		getServletContext().getRequestDispatcher("/add-company.jsp").forward(request, response);
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
