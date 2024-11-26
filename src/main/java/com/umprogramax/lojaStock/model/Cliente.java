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
@Table(name = "cliente")
@Entity(name = "cliente")
@EqualsAndHashCode(of = "id")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private String cpf;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInscricao;
	private String genero;
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

}
