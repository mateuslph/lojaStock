package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

	@NotEmpty(message = "campo-vazio")
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String unidade;
	private String ibge;
	private String gia;

}
