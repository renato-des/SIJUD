package br.com.sijud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericID {

	@Column(length = 10, nullable = false)//, unique = true) por existir numeros repetidos
	private Integer codMunicipio;

	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "codUF", nullable = false, referencedColumnName = "codUF", foreignKey = @ForeignKey(name = "FK_Estado"))
	private Estado estado;

	public Integer getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}