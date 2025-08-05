package com.doctorapp.doctor_service.service;

import com.doctorapp.doctor_service.entity.DocAppointment;
import com.doctorapp.doctor_service.repositorty.DocAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private DocAppointmentRepository docAppointmentRepository;
    @KafkaListener(topics = "appointment-booked", groupId = "doctor-group")
    public void listen(String message) {
        System.out.println("---------->Received: " + message);
        // Handle async processing, e.g. update doctor's availability
        DocAppointment docAppointment=new DocAppointment();
        docAppointment.setDocid(1);
        docAppointment.setPatientid(2);
        docAppointment.setAppoinmentdate("31-07-2025");
        docAppointmentRepository.save(docAppointment);
    }
}