package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="endereco")
@Entity(name="endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String pais;
    private String uf;
    private String municipio;
    private String logradouro;
    private String complemento;
    private String cep;

}
