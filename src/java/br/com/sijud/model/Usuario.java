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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author renat_dvxxuhs
 */
@Entity
@Table(name = "tb_usuario")
@SuppressWarnings("serial")
public class Usuario extends GenericID {

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pwd")
    private String pwd;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "papel")
    private Papel papel;

    public boolean isAdm() {
        return Papel.ADM.equals(papel);
    }

    public boolean isGerente() {
        return Papel.GERENTE.equals(papel);
    }

    public boolean isUsuarioSimples() {
        return Papel.USUARIO_SIMPLES.equals(papel);
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    @Column(name = "lastAccess", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoAcesso;

    @Column(name = "active", nullable = false, columnDefinition = "Boolean default true")
    private Boolean active;

    public Usuario() {
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

}
