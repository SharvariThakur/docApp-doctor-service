package com.doctorapp.doctor_service.service;

import com.doctorapp.doctor_service.entity.Doctor;
import com.doctorapp.doctor_service.repositorty.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    //@CacheEvict(value = "doctor", key = "'getAll'")
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Cacheable(value = "doctor", key = "'getAll'")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Cacheable(value = "doctor", key = "#id")
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    @CacheEvict(value = "doctor", key = "#id")
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @CachePut(value = "doctor", key = "#doctor.id")
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
