package com.dualentity.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dualentity.app.entity.CandyDetails;
import com.dualentity.app.helper.ListHelper;

/**
 * arugji CIS175 fall 2021 Oct 5
 */
@WebServlet("/SaveData")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListHelper lh = new ListHelper();

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

		String colour = request.getParameter("colour");
		String name = request.getParameter("name");
		long id = Long.parseLong(request.getParameter("id"));

		CandyDetails candyObj = lh.searchCandyDetailsById(id);

		if (id > 0) {
			candyObj.setColour(colour);
			candyObj.setName(name);
			lh.updateCandyDetails(candyObj);
		} else {
			candyObj = new CandyDetails();
			candyObj.setColour(colour);
			candyObj.setName(name);
			lh.insertCandyDetails(candyObj);
		}
		getServletContext().getRequestDispatcher("/ViewAllNameServlet").forward(request, response);
	}

}
