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
	private String imagem;
	@Column(precision = 8, scale = 2)
	private BigDecimal valor;

	public Produto(String nome, String descricao, String imagem,
			BigDecimal valor) {
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.valor = valor;
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(id).addValue(nome)
				.addValue(descricao).addValue(imagem).addValue(valor)
				.toString();
	}

}