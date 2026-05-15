package com.joaovictor.br.agendadordehorarios.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.joaovictor.br.agendadordehorarios.infrastructure.entity.AgendamentoEntity;
import com.joaovictor.br.agendadordehorarios.repository.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

   private final AgendamentoRepository agendamentoRepository;

   public AgendamentoEntity salvarAgendamento(AgendamentoEntity agendamento) {

      LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
      LocalDateTime horafim = agendamento.getDataHoraAgendamento().plusHours(1);

      AgendamentoEntity agendados = agendamentoRepository
            .findByServicoAndDatahoraAgendamentoBetween(agendamento.getServico(), horaAgendamento, horafim);

      if (Objects.nonNull(agendados)) {
         throw new RuntimeException("Horario ja prenchido");
      } else {
         return agendamentoRepository.save(agendamento);
      }
   }
}
