package com.aman.service.impl;

import com.aman.exception.ResourceNotFoundException;
import com.aman.model.Program;
import com.aman.repository.ProgramRepository;
import com.aman.service.IProgramService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramService implements IProgramService {
    private final ProgramRepository programRepository;

    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public Program getProgramById(Long id) {
        return programRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Program not found !"));
    }

    @Override
    public Program createProgram(Program program) throws ResourceNotFoundException{
        Optional<Program> byId = programRepository.findById(program.getId());
        return programRepository.save(program);
    }

    @Override
    public Program updateProgram(Long id, Program programDetails) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found for this id :: " + id));
        extracted(programDetails, program);
        return programRepository.save(program);
    }

    private static void extracted(Program programDetails, Program program) {
        if (programDetails.getName() != null) {
            program.setName(programDetails.getName());
        }
        if (programDetails.getPrice() != null) {
            program.setPrice(programDetails.getPrice());
        }
        if (programDetails.getDomain() != null) {
            program.setDomain(programDetails.getDomain());
        }
        if (programDetails.getProgramType() != null) {
            program.setProgramType(programDetails.getProgramType());
        }
        if (programDetails.getRegistrationsOpen() != null) {
            program.setRegistrationsOpen(programDetails.getRegistrationsOpen());
        }
        if (programDetails.getDescription() != null) {
            program.setDescription(programDetails.getDescription());
        }
        if (programDetails.getPlacementAssurance() != null) {
            program.setPlacementAssurance(programDetails.getPlacementAssurance());
        }
        if (programDetails.getImageUrl() != null) {
            program.setImageUrl(programDetails.getImageUrl());
        }
        if (programDetails.getUniversityName() != null) {
            program.setUniversityName(programDetails.getUniversityName());
        }
        if (programDetails.getFacultyProfile() != null) {
            program.setFacultyProfile(programDetails.getFacultyProfile());
        }
        if (programDetails.getLearningHoursDuration() != null) {
            program.setLearningHoursDuration(programDetails.getLearningHoursDuration());
        }
        if (programDetails.getCertificateDiploma() != null) {
            program.setCertificateDiploma(programDetails.getCertificateDiploma());
        }
        if (programDetails.getEligibilityCriteria() != null) {
            program.setEligibilityCriteria(programDetails.getEligibilityCriteria());
        }
    }


    @Override
    public void deleteProgram(Long id) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found for this id :: " + id));
        programRepository.delete(program);
    }
}
