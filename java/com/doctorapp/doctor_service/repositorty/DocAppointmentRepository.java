package com.doctorapp.doctor_service.repositorty;

import com.doctorapp.doctor_service.entity.DocAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocAppointmentRepository  extends JpaRepository<DocAppointment, Long> {
}
