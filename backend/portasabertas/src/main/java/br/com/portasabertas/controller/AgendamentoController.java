package br.com.portasabertas.controller;

import br.com.portasabertas.boundary.requestmodel.agendamento.CreateAgendamentoRequestModel;
import br.com.portasabertas.dto.PacienteExibicaoAgendamentoPsicologoDTO;
import br.com.portasabertas.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
    @Autowired
    AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<String> createAgendamento(@RequestBody CreateAgendamentoRequestModel requestModel) {
            agendamentoService.createAgendamento(requestModel);
            return ResponseEntity.ok("Agendamento feito com sucesso.");
    }

    @GetMapping("/filter")
    public List<PacienteExibicaoAgendamentoPsicologoDTO> getAll(
            @RequestParam(value = "psicologoId", required = true) final Long psicologoId) {
        return agendamentoService.getAgendamentos(psicologoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> desmarcarAgendamento(@PathVariable Long id) {
        agendamentoService.desmarcarAgendamento(id);
        return ResponseEntity.ok("Agendamento desmarcado com sucesso");
    }

}
