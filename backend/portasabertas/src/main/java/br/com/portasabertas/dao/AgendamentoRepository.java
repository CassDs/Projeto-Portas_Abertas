package br.com.portasabertas.dao;

import br.com.portasabertas.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
/*    @Query(
            value = "select a.data " +
                    "p.nome " +
                    "p.telefone " +
                    "from agendamento as a " +
                    "inner join paciente as p " +
                    "on a.paciente_id = p.id " +
                    "and p.id = :psicologoId",
            nativeQuery = true
            )
    @Modifying
    @Transactional
    Optional<List<Object>> findAllAgendamentosByPsicologo(
            @Param("psicologoId") Long psicologoId,
            @Param("date")LocalDateTime date
            );*/


    /*@Query("select u from User u where u.firstname = :#{#customer.firstname}")
    List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);*/

}
