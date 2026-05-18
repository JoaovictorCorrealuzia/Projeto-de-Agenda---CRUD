package com.joaovictor.br.agendadordehorarios.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovictor.br.agendadordehorarios.infrastructure.entity.AgendamentoEntity;

import jakarta.transaction.Transactional;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
      AgendamentoEntity findByServicoAndDatahoraAgendamentoBetween(String servico, LocalDateTime dataHorainicio,
                  LocalDateTime dataHoraFinal);

      @Transactional
      void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

      AgendamentoEntity findByDataHoraAgendamentoBetween(LocalDateTime primeiraHora, LocalDateTime horaFinalDia);
}
