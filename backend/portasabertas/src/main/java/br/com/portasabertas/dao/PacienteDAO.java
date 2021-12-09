package br.com.portasabertas.dao;

import br.com.portasabertas.dto.PacienteDTO;
import br.com.portasabertas.model.Agendamento;
import br.com.portasabertas.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PacienteDAO {
    @Autowired
    private EntityManager entityManager;

    public List<Paciente> findAllPacientesAtivosParaOPsicologo(Long psicologoId) {

        String query = "select p from paciente p" +
                " inner join p.statusPaciente s where s.id = p.psicologo.id" +
                " and p.statusPaciente.id = 2 and p.psicologo.id = :psicologoId" +
                " order by p.nome";

        var q = entityManager.createQuery(query, Paciente.class);
        q.setParameter("psicologoId", psicologoId);
        return q.getResultList();
    }
}