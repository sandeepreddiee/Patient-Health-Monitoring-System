package com.ltts.Sensor.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltts.Sensor.model.*;

public interface PatientDao extends JpaRepository<PatientModel, Integer> {
	

}
