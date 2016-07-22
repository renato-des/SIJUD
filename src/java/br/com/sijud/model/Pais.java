package br.com.sijud.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Pais extends GenericID {

	@Column(length = 10, nullable = false, unique = true)
	private Integer codPais;

	@Column(length = 150, nullable = false)
	private String nome;
	
	//bi-directional many-to-one association to regiao
    @OneToMany(mappedBy="pais")
    private List<Regiao> regioes;

	public Integer getCodPais() {
		return codPais;
	}

	public void setCodPais(Integer codPais) {
		this.codPais = codPais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the regioes
	 */
	public List<Regiao> getRegioes() {
		return regioes;
	}

	/**
	 * @param regioes the regioes to set
	 */
	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}
	
	
}
