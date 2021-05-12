package com.cvr.dao;

import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Repository;

import com.cvr.Encryption.EncryptionClass;
import com.cvr.entity.PatientEntity;
import com.cvr.model.Patient;

@Repository(value = "searchableEncryptionDAO")
public class SearchableEncryptionDAOImpl implements SearchableEncryptionDAO{

	@PersistenceContext
	private EntityManager entityManager;
	private EncryptionClass encrypting = new EncryptionClass();
	private SecretKey key;
	private byte[] iv;
	
	public void keyvalue() {
		try {
		SecretKey Symmetrickey= encrypting.createAESKey();
		key = Symmetrickey;
		byte[] initializationVector= encrypting.createInitializationVector();
		iv=initializationVector;
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public String encryption(Object input) {
		try {
			String plainText=input.toString();
			String cipherText= encrypting.do_AESEncryption(plainText,key,iv);
			return cipherText;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Object decryption(String cipherText) {
		try {
		String decryptedText = encrypting.do_AESDecryption(cipherText,key,iv);
		return decryptedText;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public int addPatient(Patient p) {
		Integer patientid=null;
		Query q=entityManager.createQuery("select m from PatientEntity m where proof_id="+p.getProof_id());
		List<PatientEntity> patientlist=q.getResultList();
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
			this.keyvalue();
			System.out.println(encryption(patientid));
			System.out.println(encryption(p.getAge()));
			System.out.println(encryption(p.getDob()));
			String name = encryption(p.getPatient_name());
			System.out.println(name);
			System.out.println(key);
			System.out.println(encryption(p.getPhone_no()));
			System.out.println(encryption(p.getProof_id()));
			System.out.println(key);
			System.out.println(decryption(name));
		}
		return patientid;
	}
}
