package com.doctorapp.doctor_service;

import com.doctorapp.doctor_service.entity.Doctor;
import com.doctorapp.doctor_service.repositorty.DoctorRepository;
import com.doctorapp.doctor_service.service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    private Doctor doctor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        doctor = new Doctor();
        doctor.setId(1L);
        doctor.setName("Dr. John");
        doctor.setSpecialization("Cardiology");
    }

    @Test
    void testAddDoctor() {
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        Doctor savedDoctor = doctorService.addDoctor(doctor);

        assertThat(savedDoctor.getName()).isEqualTo("Dr. John");
        verify(doctorRepository, times(1)).save(doctor);
    }

    @Test
    void testGetAllDoctors() {
        when(doctorRepository.findAll()).thenReturn(Arrays.asList(doctor));

        List<Doctor> doctors = doctorService.getAllDoctors();

        assertThat(doctors).hasSize(1);
        verify(doctorRepository, times(1)).findAll();
    }

    @Test
    void testGetDoctorById() {
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));

        Optional<Doctor> foundDoctor = doctorService.getDoctorById(1L);

        assertThat(foundDoctor).isPresent();
        assertThat(foundDoctor.get().getName()).isEqualTo("Dr. John");
        verify(doctorRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteDoctor() {
        doNothing().when(doctorRepository).deleteById(1L);

        doctorService.deleteDoctor(1L);

        verify(doctorRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateDoctor() {
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        Doctor updatedDoctor = doctorService.updateDoctor(doctor);

        assertThat(updatedDoctor.getName()).isEqualTo("Dr. John");
        verify(doctorRepository, times(1)).save(doctor);
    }
}
