package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@EqualsAndHashCode(of = "id")
public class Fornecedor {

    @Id
    @GeneratedValue
	@Column(columnDefinition = "UUID")
    private UUID id;
    private String nomeFantazia;
    private String cnpj;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dataInscricao;
	@ManyToOne
	@JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
