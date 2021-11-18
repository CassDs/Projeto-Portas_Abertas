package br.com.portasabertas.service;

import br.com.portasabertas.dao.PerfilRepository;
import br.com.portasabertas.dto.PerfilDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public List<PerfilDTO> getAll() {
        List<PerfilDTO> perfilDTOList = new ArrayList<PerfilDTO>();
        final var perfilList = perfilRepository.findAll();
        perfilList.forEach(perfil -> perfilDTOList.add(
                PerfilDTO.builder()
                        .id(perfil.getId())
                        .descricao(perfil.getDescricao())
                        .build()
                )
        );

        return perfilDTOList;
    }

}
