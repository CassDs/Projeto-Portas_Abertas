package br.com.portasabertas.controller;

import br.com.portasabertas.boundary.requestmodel.paciente.CreatePacienteRequestModel;
import br.com.portasabertas.dto.PacienteDTO;
import br.com.portasabertas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PacienteDTO>> getAllPacientesAtivosParaPsicologo(
            @RequestParam(value = "psicologoId") Long psicologoId) {
        final var pacientes = pacienteService.getAllPacientesAtivosParaPsicologo(psicologoId);
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<String> createPaciente(
            @RequestBody CreatePacienteRequestModel requestModel) {
        pacienteService.createPaciente(requestModel);
        return ResponseEntity.ok("Cadastro realizado com sucesso!");
    }
}
