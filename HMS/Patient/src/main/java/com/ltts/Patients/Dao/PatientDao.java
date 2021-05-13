package com.ltts.Patients.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltts.Patients.Model.*;


public interface PatientDao extends JpaRepository<PatientModel, Integer> {
	

}
