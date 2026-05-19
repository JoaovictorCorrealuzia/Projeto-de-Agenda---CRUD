package com.joaovictor.br.agendadordehorarios.service;

import java.time.LocalDate;
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

   // Marcando um horarios/ adicionando um agendamento
   public AgendamentoEntity salvarAgendamento(AgendamentoEntity agendamento) {

      LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
      LocalDateTime horafim = agendamento.getDataHoraAgendamento().plusHours(1);

      AgendamentoEntity agendados = agendamentoRepository
            .findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), horaAgendamento, horafim);

      if (Objects.nonNull(agendados)) {
         throw new RuntimeException("Horario ja prenchido");
      }
      return agendamentoRepository.save(agendamento);
   }

   // Deletando um Agendamento/ Desmarcando um Horario
   public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {
      agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
   }

   // Buscando Agendamentos
   public AgendamentoEntity buscarAgendamentosDoDia(LocalDate data) {
      LocalDateTime primeiraHora = data.atStartOfDay();
      LocalDateTime horaFinalDia = data.atTime(23, 59, 59);
      return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHora, horaFinalDia);
   }

   // Alterando agendamentos
   public AgendamentoEntity alterarAgendamentos(AgendamentoEntity agendamento, String cliente,
         LocalDateTime dataHoraAgendamento) {
      AgendamentoEntity agenda = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento,
            cliente);
      if (Objects.isNull(agenda)) {
         throw new RuntimeException("Horario não existe!");
      }
      agendamento.setId(agenda.getId());
      return agendamentoRepository.save(agendamento);
   }
}