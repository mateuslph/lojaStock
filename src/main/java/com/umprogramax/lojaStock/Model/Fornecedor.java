package com.umprogramax.lojaStock.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name="fornecedor")
@Entity(name="fornecedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nomeFantazia;
    private Integer cnpj;
    private LocalDate dataInscricao;
    private Endereco endereco;

}
