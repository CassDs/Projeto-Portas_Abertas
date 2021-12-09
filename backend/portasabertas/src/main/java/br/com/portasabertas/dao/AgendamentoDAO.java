package br.com.portasabertas.dao;

import br.com.portasabertas.model.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AgendamentoDAO {
    @Autowired
    private EntityManager entityManager;

    public List<Agendamento> findAll(Long psicologoId) {

        String query = "select a from agendamento a " +
                "inner join a.psicologo p where p.id = :psicologoId" +
                " and a.active = 1 order by a.data";

        var q = entityManager.createQuery(query, Agendamento.class);
        q.setParameter("psicologoId", psicologoId);
        return q.getResultList();
    }
}
