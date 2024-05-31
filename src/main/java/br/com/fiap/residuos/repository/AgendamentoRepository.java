package br.com.fiap.residuos.repository;

import br.com.fiap.residuos.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query("SELECT a FROM Agendamento a WHERE a.diaColeta = :diaColeta")
    public List<Agendamento> buscarPeloDiaColeta(@Param("diaColeta") LocalDate diaColeta);
}
