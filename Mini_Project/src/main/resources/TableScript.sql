create database mini_project;
use mini_project;
create table doctor(
	doctor_id INT(10) PRIMARY KEY AUTO_INCREMENT,
	doctor_name VARCHAR(30) NOT NULL,
	qualification VARCHAR(15) NOT NULL,
	age INT(3) NOT NULL,
	phone_no BIGINT(10) UNIQUE NOT NULL,
	specialist VARCHAR(25) NOT NULL
);

create table patient(
	patient_id INT(10) PRIMARY KEY AUTO_INCREMENT,
	patient_name VARCHAR(30) NOT NULL,
	age INT(3) NOT NULL,
	phone_no BIGINT(10) UNIQUE NOT NULL,
	proof_id VARCHAR(30) UNIQUE NOT NULL,
	dob DATE NOT NULL
);

create table sharing(
	sh_id INT(10) PRIMARY KEY AUTO_INCREMENT,
	doctor_id INT(10) REFERENCES doctor(doctor_id),
	patient_id INT(10) REFERENCES patient(patient_id),
	treatment VARCHAR(150) NOT NULL,
	progess INT(3) DEFAULT 0,
	description VARCHAR(300)
);

create table helper(
	id INT(10) PRIMARY KEY,
	typee VARCHAR(100) NOT NULL
);