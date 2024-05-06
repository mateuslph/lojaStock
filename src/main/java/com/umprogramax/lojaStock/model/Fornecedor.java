package com.umprogramax.lojaStock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
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
    @OneToOne
    private Endereco endereco;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeFantazia() {
		return nomeFantazia;
	}
	public void setNomeFantazia(String nomeFantazia) {
		this.nomeFantazia = nomeFantazia;
	}
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public LocalDate getDataInscricao() {
		return dataInscricao;
	}
	public void setDataInscricao(LocalDate dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
