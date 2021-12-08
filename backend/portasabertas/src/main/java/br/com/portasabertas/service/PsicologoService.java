package br.com.portasabertas.service;

import br.com.portasabertas.boundary.requestmodel.psicologo.CreatePsicologoRequestModel;
import br.com.portasabertas.dao.PerfilRepository;
import br.com.portasabertas.dao.PsicologoRepository;
import br.com.portasabertas.dto.PsicologoDTO;
import br.com.portasabertas.exception.NegocioException;
import br.com.portasabertas.model.Psicologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologoService {
    @Autowired
    PsicologoRepository psicologoRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void createPsicologo(CreatePsicologoRequestModel requestModel) {
        final var perfil = perfilRepository.getById(requestModel.getPerfilId());

        final var psicologo = Psicologo
                .builder()
                .nome(requestModel.getNome())
                .crp(requestModel.getCrp())
                .email(requestModel.getEmail())
                .perfil(perfil)
                .username(requestModel.getUsername())
                .senha(passwordEncoder.encode(requestModel.getSenha()))
                .build();

        psicologoRepository.save(psicologo);
    }

    public List<PsicologoDTO> getAll() {
        final var psicologos = psicologoRepository.findAll();
        return PsicologoDTO.convertToPsicologoDTOList(psicologos);
    }

    public PsicologoDTO getPsicologoById(Long id) {
        final var psicologo = psicologoRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return PsicologoDTO.builder()
                .nome(psicologo.getNome())
                .build();
    }


}
