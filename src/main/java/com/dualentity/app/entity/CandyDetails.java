package com.dualentity.app.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * arugji 
 * CIS175 fall 2021
 * Oct 5
 */
@Entity
@Table(name = "CandyDetails")
public class CandyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "colour", length = 100, nullable = false)
	private String colour;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "candyDetails")
	private List<CompanyDetails> companyDetails;

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

	public List<CompanyDetails> getCompanyDetails() {
		if (Objects.isNull(companyDetails)) {
			companyDetails = new ArrayList<CompanyDetails>();
		}
		return companyDetails;
	}

	public void setCompanyDetails(List<CompanyDetails> companyDetails) {
		this.companyDetails = companyDetails;
	}

}
