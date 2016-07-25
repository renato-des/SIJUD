/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author renat_dvxxuhs
 */
@Entity
@Table(name = "tb_demanda")
@SuppressWarnings("serial")
public class Demanda extends GenericID {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_nroficio")
    private String nroficio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_nrprocesso")
    private String nrprocesso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_reclamante")
    private String reclamante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_reclamado")
    private String reclamado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_tipoJustica")
    private String tipoJustica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_tribunal")
    private String tribunal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_sgUF")
    private String sgUF;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_vara")
    private String vara;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_natAcao")
    private String natAcao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_demandante")
    private String demandante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_demandada")
    private String demandada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_solicitacao")
    private String solicitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tbDm_prazoAtend")
    private Integer prazoAtend;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tbDm_dtCadastro")
    private Date dtCadastro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tbDm_dtFinal")
    private Date dtFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tbDm_dtAtendimento")
    private Date dtAtendimento;

    public String getNroficio() {
        return nroficio;
    }

    public void setNroficio(String nroficio) {
        this.nroficio = nroficio;
    }

    public String getNrprocesso() {
        return nrprocesso;
    }

    public void setNrprocesso(String nrprocesso) {
        this.nrprocesso = nrprocesso;
    }

    public String getReclamante() {
        return reclamante;
    }

    public void setReclamante(String reclamante) {
        this.reclamante = reclamante;
    }

    public String getReclamado() {
        return reclamado;
    }

    public void setReclamado(String reclamado) {
        this.reclamado = reclamado;
    }

    public String getTipoJustica() {
        return tipoJustica;
    }

    public void setTipoJustica(String tipoJustica) {
        this.tipoJustica = tipoJustica;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }

    public String getSgUF() {
        return sgUF;
    }

    public void setSgUF(String sgUF) {
        this.sgUF = sgUF;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getNatAcao() {
        return natAcao;
    }

    public void setNatAcao(String natAcao) {
        this.natAcao = natAcao;
    }

    public String getDemandante() {
        return demandante;
    }

    public void setDemandante(String demandante) {
        this.demandante = demandante;
    }

    public String getDemandada() {
        return demandada;
    }

    public void setDemandada(String demandada) {
        this.demandada = demandada;
    }

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Integer getPrazoAtend() {
        return prazoAtend;
    }

    public void setPrazoAtend(Integer prazoAtend) {
        this.prazoAtend = prazoAtend;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    public Date getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(Date dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

}
