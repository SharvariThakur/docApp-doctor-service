package com.doctorapp.doctor_service.dto;

import java.io.Serializable;

public class DocAppointmentDto implements Serializable {
    private int docid;
    private int patientid;
    private String appoinmentdate;

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getAppoinmentdate() {
        return appoinmentdate;
    }

    public void setAppoinmentdate(String appoinmentdate) {
        this.appoinmentdate = appoinmentdate;
    }

    public DocAppointmentDto(int docid, int patientid, String appoinmentdate) {
        this.docid = docid;
        this.patientid = patientid;
        this.appoinmentdate = appoinmentdate;
    }

    public DocAppointmentDto() {
    }
}
