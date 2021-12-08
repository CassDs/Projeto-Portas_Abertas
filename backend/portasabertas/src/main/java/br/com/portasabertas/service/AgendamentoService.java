package br.com.portasabertas.service;

import br.com.portasabertas.boundary.requestmodel.agendamento.CreateAgendamentoRequestModel;
import br.com.portasabertas.dao.AgendamentoDAO;
import br.com.portasabertas.dao.AgendamentoRepository;
import br.com.portasabertas.dao.PacienteRepository;
import br.com.portasabertas.dao.PsicologoRepository;
import br.com.portasabertas.dto.PacienteExibicaoAgendamentoPsicologoDTO;
import br.com.portasabertas.model.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class AgendamentoService {
    @Autowired
    private Validator validator;
    @Autowired
    AgendamentoRepository agendamentoRepository;
    @Autowired
    AgendamentoDAO agendamentoDAO;
    @Autowired
    PsicologoRepository psicologoRepository;
    @Autowired
    PacienteRepository pacienteRepository;

    public void createAgendamento(CreateAgendamentoRequestModel requestModel) {

        Assert.notNull(requestModel, "Informe os dados");

        Set<ConstraintViolation<CreateAgendamentoRequestModel>> violations =
                validator.validate(requestModel);

        if(violations.isEmpty()) {
            final var psicologo =
                    psicologoRepository.findById(requestModel.getPsicologoId()).orElse(null);
            final var paciente =
                    pacienteRepository.findById(requestModel.getPacienteId()).orElse(null);

            final var agendamento = Agendamento.builder()
                    .paciente(paciente)
                    .psicologo(psicologo)
                    .data(requestModel.getDataHora())
                    .build();
            agendamentoRepository.save(agendamento);

        }
    }

    public List<PacienteExibicaoAgendamentoPsicologoDTO> getAgendamentos(Long psicologoId) {
        final var agendamentos =  agendamentoDAO.findAll(psicologoId);
        return PacienteExibicaoAgendamentoPsicologoDTO.convertToPacienteAgendamentoDTOList(agendamentos);
    }
}
