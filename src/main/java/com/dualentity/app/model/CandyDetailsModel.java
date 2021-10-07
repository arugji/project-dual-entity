package com.dualentity.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * arugji 
 * CIS175 fall 2021
 * Oct 5
 */
public class CandyDetailsModel {

	private Long id;

	private String name;

	private String colour;

	private List<CompanyDetailsModel> companyDetails;

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

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public List<CompanyDetailsModel> getCompanyDetails() {
		if (Objects.isNull(companyDetails)) {
			companyDetails = new ArrayList<CompanyDetailsModel>();
		}
		return companyDetails;
	}

	public void setCompanyDetails(List<CompanyDetailsModel> companyDetails) {
		this.companyDetails = companyDetails;
	}

}
