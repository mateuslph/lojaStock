package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "funcionario")
@Entity(name = "funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private Integer cpf;
    private String registro;
    private String tipo;
    private Endereco endereco;

}
