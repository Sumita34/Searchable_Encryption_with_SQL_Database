package com.cvr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sharing")
public class SharingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sh_id;
	private int doctor_id;
	private int patient_id;
	private String treatment;
	private int progess;
	private String description;
}
