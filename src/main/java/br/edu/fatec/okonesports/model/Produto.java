package br.edu.fatec.okonesports.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	@Column(precision = 8, scale = 2)
	private BigDecimal valor;
	private String marca;
	private Long idCategoria;

	public Produto(String nome, String descricao, BigDecimal valor,
			String marca, Long idCategoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.marca = marca;
		this.idCategoria = idCategoria;
	}

	public Produto() {

	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(id).addValue(nome)
				.addValue(descricao).addValue(valor).addValue(marca)
				.addValue(idCategoria).toString();
	}

}