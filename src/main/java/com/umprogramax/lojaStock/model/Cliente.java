package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
@Entity(name = "cliente")
@EqualsAndHashCode(of = "id")
public class Cliente {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "UUID")
	private UUID id;
	private String nome;
	private String cpf;
	private String dataInscricao;
	private String genero;
	@OneToOne
	private Endereco endereco;
}
