package com.joaovictor.br.agendadordehorarios.infrastructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "agendamento")
public class AgendamentoEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String servico;

   private String telefoneClinte;

   private String profissional;

   private LocalDateTime dataHoraAgendamento;

   private String cliente;

   private LocalDateTime dataInsercao = LocalDateTime.now();
}
