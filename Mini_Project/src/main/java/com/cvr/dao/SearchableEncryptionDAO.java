package com.cvr.dao;

import com.cvr.model.Patient;

public interface SearchableEncryptionDAO {
	public int addPatient(Patient p);
	public String encryption(Object input);
	public Object decryption(String cipherText);
}
