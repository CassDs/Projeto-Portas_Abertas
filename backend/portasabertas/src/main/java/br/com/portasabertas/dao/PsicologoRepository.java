package br.com.portasabertas.dao;

import br.com.portasabertas.model.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
    Optional<Psicologo> findByEmail(String email);
    Optional<Psicologo> findByCrp(String crp);
}
