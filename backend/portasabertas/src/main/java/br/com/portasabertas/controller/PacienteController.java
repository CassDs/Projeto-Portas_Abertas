package br.com.portasabertas.controller;

import br.com.portasabertas.boundary.requestmodel.CreatePacienteRequestModel;
import br.com.portasabertas.dto.PacienteDTO;
import br.com.portasabertas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public List<PacienteDTO> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @PostMapping
    public ResponseEntity<String> createPaciente(
            @RequestBody CreatePacienteRequestModel requestModel) {
        pacienteService.createPaciente(requestModel);
        return ResponseEntity.ok("Cadastro realizado com sucesso!");
    }
}
