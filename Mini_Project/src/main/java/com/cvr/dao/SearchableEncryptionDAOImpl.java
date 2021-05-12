package com.cvr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.cvr.entity.PatientEntity;
import com.cvr.model.Patient;

@Repository(value = "searchableEncryptionDAO")
public class SearchableEncryptionDAOImpl implements SearchableEncryptionDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public int addPatient(Patient p) {
		Integer patientid=null;
		System.out.println("ok2");
		Query q=entityManager.createQuery("select m from PatientEntity m where proof_id="+p.getProof_id());
		List<PatientEntity> patientlist=q.getResultList();
		System.out.println("ok");
		if(patientlist.size()>0) {
			System.out.println("Patient already exists");
		}
		else {
			PatientEntity pe = new PatientEntity();
			pe.setPatient_id(p.getPatient_id());
			pe.setAge(p.getAge());
			pe.setDob(p.getDob());
			pe.setPatient_name(p.getPatient_name());
			pe.setPhone_no(p.getPhone_no());
			pe.setProof_id(p.getProof_id());
			entityManager.persist(pe);
			patientid = pe.getPatient_id();
		}
		return patientid;
	}
}
