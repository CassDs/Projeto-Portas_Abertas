package br.com.portasabertas.controller;

import br.com.portasabertas.boundary.requestmodel.psicologo.CreatePsicologoRequestModel;
import br.com.portasabertas.dto.PsicologoDTO;
import br.com.portasabertas.model.Psicologo;
import br.com.portasabertas.service.PsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/psicologos")
@CrossOrigin(origins = "http://localhost:4200")
public class PsicologoController {

    @Autowired
    PsicologoService psicologoService;

    @PostMapping
    public ResponseEntity<String> createPsicologo(@RequestBody CreatePsicologoRequestModel requestModel) {
        psicologoService.createPsicologo(requestModel);
        return ResponseEntity.ok("Psicólogo cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<PsicologoDTO>> getAllPsicologos() {
        final var psicologos = psicologoService.getAll();
        return ResponseEntity.ok(psicologos);
    }

}
