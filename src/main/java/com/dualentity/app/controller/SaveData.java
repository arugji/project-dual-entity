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
@WebServlet("/SaveData")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveData() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		String colour = request.getParameter("colour");
		String name = request.getParameter("name");
		long id = Long.parseLong(request.getParameter("id"));

		entityManager.getTransaction().begin();
		CandyDetails candyObj = entityManager.find(CandyDetails.class, id);

		if (id > 0) {
			candyObj.setColour(colour);
			candyObj.setName(name);
			entityManager.merge(candyObj);
		} else {
			candyObj = new CandyDetails();
			candyObj.setColour(colour);
			candyObj.setName(name);
			entityManager.persist(candyObj);
		}
		entityManager.getTransaction().commit();
		entityManager.refresh(candyObj);
		getServletContext().getRequestDispatcher("/ViewAllNameServlet").forward(request, response);
	}

}
