package com.dualentity.app.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.dualentity.app.entity.CandyDetails;
import com.dualentity.app.entity.CompanyDetails;
import com.dualentity.app.model.CandyDetailsModel;
import com.dualentity.app.model.CompanyDetailsModel;
import com.dualentity.app.util.EntityManagerUtil;

/**
 * arugji CIS175 fall 2021 Oct 5
 */

public class ListHelper {

	public void insertCandyDetails(CandyDetails candyObj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(candyObj);
		entityManager.getTransaction().commit();
		entityManager.refresh(candyObj);
		entityManager.close();
	}

	public void updateCandyDetails(CandyDetails candyObj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(candyObj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public CandyDetails searchCandyDetailsById(long id) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		CandyDetails candyObj = entityManager.find(CandyDetails.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return candyObj;
	}

	public void deleteCandyDetails(CandyDetails candyObj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(candyObj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void insertCompanyDetails(CompanyDetails companyDetails) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(companyDetails);
		entityManager.getTransaction().commit();
		entityManager.refresh(companyDetails);
		entityManager.close();
	}

	public void insertCompanyDetails(String name, long candyId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		CandyDetails candyObj = entityManager.find(CandyDetails.class, candyId);
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setCandyDetails(candyObj);
		companyDetails.setName(name);
		entityManager.persist(companyDetails);
		entityManager.getTransaction().commit();
		entityManager.refresh(companyDetails);
		entityManager.close();
	}

	public List<CandyDetailsModel> loadAllCandyDetails() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<CandyDetails> list = (List<CandyDetails>) entityManager.createQuery("SELECT u FROM CandyDetails u")
				.getResultList();
		List<CandyDetailsModel> candyDetailsModelList = new ArrayList<CandyDetailsModel>();
		for (CandyDetails cd : list) {
			CandyDetailsModel cdm = new CandyDetailsModel();
			cdm.setColour(cd.getColour());
			cdm.setId(cd.getId());
			cdm.setName(cd.getName());

			for (CompanyDetails cmObj : cd.getCompanyDetails()) {
				CompanyDetailsModel cmdm = new CompanyDetailsModel();
				cmdm.setId(cmObj.getId());
				cmdm.setName(cmObj.getName());
				cdm.getCompanyDetails().add(cmdm);
			}
			candyDetailsModelList.add(cdm);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return candyDetailsModelList;
	}
}
