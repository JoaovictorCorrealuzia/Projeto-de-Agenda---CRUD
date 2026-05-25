package com.joaovictor.br.agendadordehorarios.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovictor.br.agendadordehorarios.infrastructure.entity.AgendamentoEntity;

import jakarta.transaction.Transactional;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
      AgendamentoEntity findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio,
                  LocalDateTime dataHoraFinal);

      @Transactional
      void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

      List<AgendamentoEntity> findByDataHoraAgendamentoBetween(LocalDateTime primeiraHora, LocalDateTime horaFinalDia);

      AgendamentoEntity findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

}
