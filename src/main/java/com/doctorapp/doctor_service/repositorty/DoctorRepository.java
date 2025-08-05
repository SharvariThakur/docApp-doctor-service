package com.doctorapp.doctor_service.repositorty;



import com.doctorapp.doctor_service.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}