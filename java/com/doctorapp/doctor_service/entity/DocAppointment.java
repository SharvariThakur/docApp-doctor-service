package com.doctorapp.doctor_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="docappointment")
public class DocAppointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int docid;
    private int patientid;
    private String appoinmentdate;

    public DocAppointment(int id, int docid, int patientid, String appoinmentdate) {
        this.id = id;
        this.docid = docid;
        this.patientid = patientid;
        this.appoinmentdate = appoinmentdate;
    }

    public DocAppointment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
