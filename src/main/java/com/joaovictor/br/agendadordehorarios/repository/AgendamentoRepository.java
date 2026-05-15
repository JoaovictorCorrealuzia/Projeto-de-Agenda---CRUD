package com.joaovictor.br.agendadordehorarios.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovictor.br.agendadordehorarios.infrastructure.entity.AgendamentoEntity;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
   AgendamentoEntity findByServicoAndDatahoraAgendamentoBetween(String servico, LocalDateTime dataHorainicio,
         LocalDateTime dataHoraFinal);
}
