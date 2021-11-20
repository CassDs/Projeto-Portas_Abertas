package br.com.portasabertas.service;

import br.com.portasabertas.dao.PerfilRepository;
import br.com.portasabertas.dto.PerfilDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilDTO> getAll() {
        final var perfilList = perfilRepository.findAll();
        return PerfilDTO.convertToPerfilDTOList(perfilList);
    }

}
