package com.cvr.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvr.dao.SearchableEncryptionDAO;
import com.cvr.model.Patient;

@Service(value="searchableEncryptionService")
@Transactional
public class SearchableEncryptionServiceImpl implements SearchableEncryptionService{
	@Autowired
	private SearchableEncryptionDAO searchableEncryptionDAO;
	
	public int addPatient() {
		Patient p =new Patient();
		p.setAge(15);
		p.setDob(new Date());
		p.setPatient_name("abc");
		p.setPhone_no(1124562820);
		p.setProof_id("123511341145");
		int pid=searchableEncryptionDAO.addPatient(p);
		System.out.println(pid);
		return pid;
	}
}
