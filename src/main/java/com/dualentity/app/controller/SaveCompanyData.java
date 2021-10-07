package com.dualentity.app.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dualentity.app.entity.CandyDetails;
import com.dualentity.app.entity.CompanyDetails;
import com.dualentity.app.util.EntityManagerUtil;

/**
 * arugji 
 * CIS175 fall 2021
 * Oct 5
 */
@WebServlet("/SaveCompanyData")
public class SaveCompanyData extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		CandyDetails candyObj = entityManager.find(CandyDetails.class, Long.parseLong(candyId));
		CompanyDetails cm = new CompanyDetails();
		cm.setCandyDetails(candyObj);
		cm.setName(request.getParameter("name"));
		entityManager.persist(cm);
		entityManager.getTransaction().commit();
		entityManager.refresh(cm);
		getServletContext().getRequestDispatcher("/ViewAllNameServlet").forward(request, response);
	}

}
