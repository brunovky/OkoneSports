package br.edu.fatec.okonesports.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.base.Objects;

import br.edu.fatec.okonesports.enums.TipoUsuario;

@Entity
public class Usuario /*extends DefaultAdapter<UsuarioVO>*/ {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String rg;
	private String cpf;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	@Enumerated
	private TipoUsuario tipo;
	private Long idEndereco;
	private Boolean ativo;

	public Usuario(String nome, String email, String senha, String rg,
			String cpf, Calendar dataNascimento, TipoUsuario tipo,
			Long idEndereco, Boolean ativo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.tipo = tipo;
		this.idEndereco = idEndereco;
		this.ativo = ativo;
	}

	public Usuario() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(id).addValue(nome)
				.addValue(email).addValue(senha).addValue(rg).addValue(cpf)
				.addValue(dataNascimento).addValue(tipo).addValue(idEndereco)
				.addValue(ativo).toString();
	}

}