package br.com.sijud.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericID {

	@Column(length = 10, nullable = false, unique = true)
	private Integer codUF;

	@Column(length = 2, nullable = false)
	private String sigla;

	@Column(length = 50, nullable = false)
	private String nome;

	@OneToOne
	@JoinColumn(name = "codRegiao", nullable = false, referencedColumnName = "codRegiao", foreignKey = @ForeignKey(name = "FK_Regiao"))
	private Regiao regiao;

	// bi-directional many-to-one association to regiao
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public Integer getCodUF() {
		return codUF;
	}

	public void setCodUF(Integer codUF) {
		this.codUF = codUF;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cidades
	 */
	public List<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * @param cidades
	 *            the cidades to set
	 */
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}