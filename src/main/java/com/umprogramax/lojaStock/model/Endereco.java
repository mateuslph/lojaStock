package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
@Entity(name = "endereco")
@EqualsAndHashCode(of = "id")
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	private String pais;
	private String uf;
	private String municipio;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;

}
