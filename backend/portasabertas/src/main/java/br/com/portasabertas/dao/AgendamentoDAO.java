package br.com.portasabertas.dao;

import br.com.portasabertas.dao.sql.NativeSQLQuery;
import br.com.portasabertas.model.Agendamento;
import br.com.portasabertas.model.AgendamentoPacienteParaODiaPsicologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AgendamentoDAO {
    @Autowired
    private EntityManager entityManager;

    public List<Agendamento> findAll(Long psicologoId, LocalDateTime data) {

        String query = "select a from agendamento a " +
                "inner join a.psicologo p where p.id = :psicologoId" +
                " and year(a.data) = year(:data) and month(a.data) = month(:data) and day(a.data) = day(:data)";

        var q = entityManager.createQuery(query, Agendamento.class);
        q.setParameter("psicologoId", psicologoId);
        q.setParameter("data", data);
        return q.getResultList();
    }
}
