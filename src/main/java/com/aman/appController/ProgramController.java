package com.aman.appController;

import com.aman.model.Program;
import com.aman.service.IProgramService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    private final IProgramService programService;

    public ProgramController(IProgramService programService) {
        this.programService = programService;
    }
    @GetMapping("/test")
    public String test() {
        return "testing........";
    }

    @GetMapping
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long id) {
        Program program = programService.getProgramById(id);
        return ResponseEntity.ok(program);
    }

    @PostMapping
    public Program createProgram(@RequestBody @Valid Program program) {
        return programService.createProgram(program);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program programDetails) {
        Program updatedProgram = programService.updateProgram(id, programDetails);
        return ResponseEntity.ok(updatedProgram);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        programService.deleteProgram(id);
        return ResponseEntity.noContent().build();
    }
}

