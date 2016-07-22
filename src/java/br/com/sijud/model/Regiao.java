package br.com.sijud.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Regiao extends GenericID {

	@Column(length = 3, nullable = false, unique = true)
	private Integer codRegiao;

	@Column(length = 150, nullable = false)
	private String nome;

	// bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name = "codPais", nullable = false, referencedColumnName = "codPais", foreignKey = @ForeignKey(name = "FK_Pais"))
	private Pais pais;

	// bi-directional many-to-one association to regiao
	@OneToMany(mappedBy = "regiao")
	private List<Estado> estados;

	public Integer getCodRegiao() {
		return codRegiao;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public void setCodRegiao(Integer codRegiao) {
		this.codRegiao = codRegiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the estados
	 */
	public List<Estado> getEstados() {
		return estados;
	}

	/**
	 * @param estados
	 *            the estados to set
	 */
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
