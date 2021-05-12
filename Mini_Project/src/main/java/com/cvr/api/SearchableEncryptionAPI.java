package com.cvr.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvr.service.SearchableEncryptionService;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class SearchableEncryptionAPI {
	@Autowired
	SearchableEncryptionService serviceobj;
	
	@GetMapping("/addPatient")
	public ResponseEntity<String> addUser() {
		Integer patientId = serviceobj.addPatient();
		if(patientId==null) {
			return new ResponseEntity<String>("Patient already exists", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<String>("Patient Id:"+patientId, HttpStatus.OK);
		}
	}
	
	
}
