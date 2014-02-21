package br.edu.fatec.okonesports.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.base.Objects;

@Entity
public class Carrinho /*extends DefaultAdapter<CarrinhoVO>*/ {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	@Column(precision = 8, scale = 2)
	private BigDecimal valorTotal;
	private Long idCliente;

	public Carrinho(Calendar data, BigDecimal valorTotal, Long idCliente) {
		this.data = data;
		this.valorTotal = valorTotal;
		this.idCliente = idCliente;
	}

	public Carrinho() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(id).addValue(data)
				.addValue(valorTotal).addValue(idCliente).toString();
	}

}