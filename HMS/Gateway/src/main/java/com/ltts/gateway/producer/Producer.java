package com.ltts.gateway.producer;

public class Producer {

	
    private int patientid;
private int oxygenlevel;
private int heartrate;
private int bloodpressure;
private String timestamp;



public Producer() {
	super();
}
public Producer(int patientid, int oxygenlevel, int heartrate, int bloodpressure, String timestamp) {
	super();
	this.patientid = patientid;
	this.oxygenlevel = oxygenlevel;
	this.heartrate = heartrate;
	this.bloodpressure = bloodpressure;
	this.timestamp = timestamp;
}
public int getPatientid() {
	return patientid;
}
public void setPatientid(int patientid) {
	this.patientid = patientid;
}
public int getOxygenlevel() {
	return oxygenlevel;
}
public void setOxygenlevel(int oxygenlevel) {
	this.oxygenlevel = oxygenlevel;
}
public int getHeartrate() {
	return heartrate;
}
public void setHeartrate(int heartrate) {
	this.heartrate = heartrate;
}
public int getBloodpressure() {
	return bloodpressure;
}
public void setBloodpressure(int bloodpressure) {
	this.bloodpressure = bloodpressure;
}
public String getTimestamp() {
	return timestamp;
}
public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
}
@Override
public String toString() {
	return "Producer [patientid=" + patientid + ", oxygenlevel=" + oxygenlevel + ", heartrate=" + heartrate
			+ ", bloodpressure=" + bloodpressure + ", timestamp=" + timestamp + "]";
}


}
