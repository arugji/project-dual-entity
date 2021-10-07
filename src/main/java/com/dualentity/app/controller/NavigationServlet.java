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

@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		String act = request.getParameter("btn-op");
		String path = "/ViewAllNameServlet";

		if (act.equals("delete")) {
			String candyId = request.getParameter("id");
			if (candyId != null && !candyId.trim().isEmpty()) {
				entityManager.getTransaction().begin();
				CandyDetails candyObj = entityManager.find(CandyDetails.class, Long.parseLong(candyId));
				entityManager.remove(candyObj);
				entityManager.getTransaction().commit();
			} else {
				path = "/error.jsp";
			}
		} else if (act.equals("edit")) {
			path = "/edit.jsp";
			String candyId = request.getParameter("id");
			if (candyId != null && !candyId.trim().isEmpty()) {
				entityManager.getTransaction().begin();
				CandyDetails candyObj = entityManager.find(CandyDetails.class, Long.parseLong(candyId));
				entityManager.getTransaction().commit();
				request.setAttribute("candy", candyObj);
			} else {
				path = "/error.jsp";
			}
		} else if (act.equals("add")) {
			path = "/index.jsp";
		} else if (act.equals("add-company-details")) {
			String candyId = request.getParameter("id");
			if (candyId != null && !candyId.trim().isEmpty()) {
				path = "/ViewAddCompany";
			} else {
				path = "/error.jsp";
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
