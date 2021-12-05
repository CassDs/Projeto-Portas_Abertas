package br.com.portasabertas.service;

import br.com.portasabertas.boundary.requestmodel.paciente.CreatePacienteRequestModel;
import br.com.portasabertas.dao.PacienteRepository;
import br.com.portasabertas.dao.StatusPacienteRepository;
import br.com.portasabertas.dto.PacienteDTO;
import br.com.portasabertas.exception.NegocioException;
import br.com.portasabertas.model.Paciente;
import br.com.portasabertas.model.StatusPacienteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.List;
import java.util.Set;

@Service
public class PacienteService {
    @Autowired
    private Validator validator;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private StatusPacienteRepository statusPacienteRepository;


    public List<PacienteDTO> getAllPacientes() {
        final var pacientes = this.pacienteRepository.findAll();
        return PacienteDTO.convertToPacienteDTOList(pacientes);
    }

    public void createPaciente(CreatePacienteRequestModel requestModel) {
        Assert.notNull(requestModel, "Informe os dados");

        Set<ConstraintViolation<CreatePacienteRequestModel>> violations =
                validator.validate(requestModel);

        if(violations.isEmpty()) {
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
                    .relato(requestModel.getRelato())
                    .telefone(requestModel.getTelefone())
                    .build();

            pacienteRepository.save(paciente);
        } else {
            throw new NegocioException((violations.stream().findFirst().get().getMessage()));
        }
    }

}
