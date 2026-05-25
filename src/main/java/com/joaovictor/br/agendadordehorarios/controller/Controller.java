package com.joaovictor.br.agendadordehorarios.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaovictor.br.agendadordehorarios.infrastructure.entity.AgendamentoEntity;
import com.joaovictor.br.agendadordehorarios.service.AgendamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {
   private final AgendamentoService agendamentoService;

   @PostMapping("/SalvarAgendamento")
   public ResponseEntity<AgendamentoEntity> salvarAgendamento(@RequestBody AgendamentoEntity agendamento) {
      return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
   }

   @DeleteMapping("/DeletarAgendamento")
   public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente, @RequestParam LocalDateTime horario) {
      agendamentoService.deletarAgendamento(horario, cliente);
      return ResponseEntity.noContent().build();
   }

   @GetMapping("/BuscarAgendamento")
   public ResponseEntity<AgendamentoEntity> buscarAgendamentosDia(@RequestParam LocalDate date) {
      return ResponseEntity.accepted().body(agendamentoService.buscarAgendamentosDoDia(date));
   }

   @PutMapping("/AlterarRegistro")
   public ResponseEntity<AgendamentoEntity> alterarAgendamentos(@RequestParam String cliente,
         @RequestParam LocalDateTime horario, @RequestBody AgendamentoEntity agendamento) {
      return ResponseEntity.accepted().body(agendamentoService.alterarAgendamentos(agendamento, cliente, horario));
   }
}
