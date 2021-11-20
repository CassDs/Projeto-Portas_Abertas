package br.com.portasabertas.service;

import br.com.portasabertas.boundary.requestmodel.CreatePacienteRequestModel;
import br.com.portasabertas.dao.PacienteRepository;
import br.com.portasabertas.dao.StatusPacienteRepository;
import br.com.portasabertas.dto.PacienteDTO;
import br.com.portasabertas.model.EnderecoPaciente;
import br.com.portasabertas.model.Paciente;
import br.com.portasabertas.model.StatusPaciente;
import br.com.portasabertas.model.StatusPacienteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private StatusPacienteRepository statusPacienteRepository;


    public List<PacienteDTO> getAllPacientes() {
        final var pacientes = this.pacienteRepository.findAll();
        return PacienteDTO.convertToPacienteDTOList(pacientes);
    }

    public void createPaciente(CreatePacienteRequestModel requestModel) {
        final var statusPaciente =
                statusPacienteRepository.findById(
                        StatusPacienteEnum.AGUARDANDO.getValue()
                ).orElse(null);

        final var paciente = Paciente.builder()
                .nome(requestModel.getNome())
                .conhecimento(requestModel.getConhecimento())
                .dataNascimento(requestModel.getDataNascimento())
                .escolaridade(requestModel.getEscolaridade())
                .genero(requestModel.getGenero())
                .statusPaciente(statusPaciente)
                .profissao(requestModel.getProfissao())
                .build();

        pacienteRepository.save(paciente);

    }
}
