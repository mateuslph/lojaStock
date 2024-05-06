package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "cliente")
@Entity(name = "cliente")
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
    @OneToOne
    private Endereco endereco;
    
	public String getId() {
		return id;
	}	
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataInscricao() {
		return dataInscricao;
	}
	public void setDataInscricao(LocalDate dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
