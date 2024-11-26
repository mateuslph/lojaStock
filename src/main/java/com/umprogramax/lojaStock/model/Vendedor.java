package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vendedor")
@Entity(name = "vendedor")
@EqualsAndHashCode(of = "id")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String cpf;
    private String registro;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
