package com.umprogramax.lojaStock.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "cliente")
@Entity(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private Integer cpf;
    private LocalDate dataInscricao;
    private String genero;
    private Endereco endereco;

}
