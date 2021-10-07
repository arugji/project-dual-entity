package com.dualentity.app.model;

/**
 * arugji 
 * CIS175 fall 2021
 * Oct 5
 */
public class CompanyDetailsModel {

	private Long id;

	private String name;

	private CandyDetailsModel candyDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CandyDetailsModel getCandyDetails() {
		return candyDetails;
	}

	public void setCandyDetails(CandyDetailsModel candyDetails) {
		this.candyDetails = candyDetails;
	}

}
