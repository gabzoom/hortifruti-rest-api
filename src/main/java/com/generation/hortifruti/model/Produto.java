package com.generation.hortifruti.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo Nome é obrigatório!")
	@Size(min = 3, max = 255, message = "O atributo Nome deve conter entre 3 e 255 caracteres.")
	private String nome;

	@NotNull(message = "O atributo Preço é obrigatório!")
	@Column(precision = 8, scale = 2)
	@Digits(integer = 6, fraction = 2, message = "O atributo Preço deve ter no máximo 6 dígitos inteiros e 2 dígitos decimais.")
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal preco;

	private String foto;

	@Column(length = 500)
	@Size(min = 3, max = 500, message = "O atributo Descrição deve conter entre 3 e 500 caracteres.")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}