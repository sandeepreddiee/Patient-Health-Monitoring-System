package com.ltts.Sensor.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class  PatientModel{
	
	
	 @Id 
    private final int Pid=1;
	private String timestamp;
	private int Oxygen_Level;
	private int Blood_Pressure;
	private int Heart_Rate;
	
	
	
	public PatientModel() {
		super();
	}
	public PatientModel(String timestamp, int oxygen_Level, int blood_Pressure, int heart_Rate) {
		super();
		this.timestamp = timestamp;
		Oxygen_Level = oxygen_Level;
		Blood_Pressure = blood_Pressure;
		Heart_Rate = heart_Rate;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getOxygen_Level() {
		return Oxygen_Level;
	}
	public void setOxygen_Level(int oxygen_Level) {
		Oxygen_Level = oxygen_Level;
	}
	public int getBlood_Pressure() {
		return Blood_Pressure;
	}
	public void setBlood_Pressure(int blood_Pressure) {
		Blood_Pressure = blood_Pressure;
	}
	public int getHeart_Rate() {
		return Heart_Rate;
	}
	public void setHeart_Rate(int heart_Rate) {
		Heart_Rate = heart_Rate;
	}
	public int getPid() {
		return Pid;
	}
	@Override
	public String toString() {
		return "PatientModel [Pid=" + Pid + ", timestamp=" + timestamp + ", Oxygen_Level=" + Oxygen_Level
				+ ", Blood_Pressure=" + Blood_Pressure + ", Heart_Rate=" + Heart_Rate + "]";
	}
  
	
	
	
		
}
