package br.com.portasabertas.controller;

import br.com.portasabertas.boundary.requestmodel.agendamento.CreateAgendamentoRequestModel;
import br.com.portasabertas.dto.PacienteExibicaoAgendamentoPsicologoDTO;
import br.com.portasabertas.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
            @RequestParam(value = "psicologoId", required = true) final Long psicologoId,
            @RequestParam(value = "dateTime", required = true)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            final LocalDateTime dateTime) {
        return agendamentoService.getAgendamentos(psicologoId, dateTime);
    }

}
