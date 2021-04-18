package com.pawelwlazlo.dentalclinic.service.patient;

import com.pawelwlazlo.dentalclinic.exception.patient.PatientEmailExistException;
import com.pawelwlazlo.dentalclinic.exception.patient.PatientNotFoundException;
import com.pawelwlazlo.dentalclinic.exception.patient.PatientPESELExistException;
import com.pawelwlazlo.dentalclinic.model.Patient;
import com.pawelwlazlo.dentalclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        patient.setPatientCode(UUID.randomUUID().toString());

        calculatePatientAge(patient);

        patientEmailOrPeselExist(patient);


        return patientRepository.save(patient);
    }

    private void calculatePatientAge(Patient patient) {
        int currentYear = new Date().getYear();
        int yearOfBirth = Integer.parseInt(patient.getPESEL().substring(0, 2));
        int patientAge = currentYear - yearOfBirth;
        //TODO age must be calculate with month


        patient.setAge(patientAge);
    }


    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Patient patient) {
        checkIfOthersHaveEmailOrPhone(patient);
        calculatePatientAge(patient);
        return patientRepository.save(patient);
    }

    private void checkIfOthersHaveEmailOrPhone(Patient patient) {
        Long id = patient.getId();
        String email = patient.getEmail();
        String pesel = patient.getPESEL();
        if (patientRepository.existsPatientByEmailAndIdIsNot(email,id)) {
            throw new PatientEmailExistException("Email " + email + " already exist");
        }
        else if (patientRepository.existsPatientByPESELAndIdIsNot(pesel,id)) {
            throw new PatientPESELExistException("Pesel " + pesel + " already exist");
        }
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findPatientById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient by id " + id + " was not found"));
    }

    public Patient findPatientByPesel(String pesel) {
        return patientRepository.findPatientByPESEL(pesel)
                .orElseThrow(() -> new PatientNotFoundException("Pesel " + pesel + " was not found"));
    }

    public Page<Patient> getPaginatedPatient(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        ;
        return patientRepository.findAll(pageable);
    }

    public Page<Patient> getPaginatedAndSortingPatient(int pageNo, int pageSize, String column, boolean descending) {
        Pageable pageable;
        if (descending) {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(column).descending());
        } else {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(column));

        }


        return patientRepository.findAll(pageable);
    }

    private void patientEmailOrPeselExist(Patient patient) {
        if (patientRepository.existsPatientByEmail(patient.getEmail())) {
            throw new PatientEmailExistException("Email " + patient.getEmail() + " already exist");
        } else if (patientRepository.existsPatientByPESEL(patient.getPESEL())) {
            throw new PatientPESELExistException("Pesel " + patient.getPESEL() + " already exist");
        }
    }
}
