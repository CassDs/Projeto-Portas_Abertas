package br.com.portasabertas.dao;

import br.com.portasabertas.model.StatusPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPacienteRepository extends JpaRepository<StatusPaciente, Long> {
}
