package br.edu.fatec.okonesports.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class ItemCarrinho /*extends DefaultAdapter<ItemCarrinhoVO>*/ {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer quantidade;
	private Long idProduto;
	private Long idCarrinho;

	public ItemCarrinho(Integer quantidade, Long idProduto, Long idCarrinho) {
		this.quantidade = quantidade;
		this.idProduto = idProduto;
		this.idCarrinho = idCarrinho;
	}

	public ItemCarrinho() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(id).addValue(quantidade)
				.addValue(idProduto).addValue(idCarrinho).toString();
	}

}