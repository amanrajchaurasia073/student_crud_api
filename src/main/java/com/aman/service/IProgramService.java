package com.aman.service;

import com.aman.model.Program;

import java.util.List;


public interface IProgramService {
    List<Program> getAllPrograms();

    Program getProgramById(Long id);

    Program createProgram(Program program);

    Program updateProgram(Long id, Program programDetails);

    void deleteProgram(Long id);
}
