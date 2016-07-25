/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.bean;

import br.com.sijud.dao.UsuarioDAO;
import br.com.sijud.model.Papel;
import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import br.com.sijud.util.FacesUtil;
import br.com.sijud.util.RedirecionaPages;
import br.com.sijud.util.SessionContext;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author renat_dvxxuhs
 */
@ManagedBean
@SessionScoped
@SuppressWarnings("serial")
public class AutenticacaoBean implements Serializable {

    private static final Logger logger = LogManager.getLogger(AutenticacaoBean.class);
    
    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        Pessoa pessoa = new Pessoa();
        usuario.setPessoa(pessoa);
    }

    public String autenticar() {
        UsuarioDAO usrDAO = new UsuarioDAO();
        usuario = usrDAO.autenticarUsuario(usuario.getLogin(), usuario.getPwd());
        if (usuario != null) {
            UsuarioLogado usuarioLogado = new UsuarioLogado(usuario.getPapel(), usuario.getPessoa().getFirstName() + " " + usuario.getPessoa().getLastName(), Boolean.TRUE,usuario.getUltimoAcesso());
        usuario.setUltimoAcesso(new Date());
            usrDAO.updateUltimoAcesso(usuario);
            SessionContext.getInstance().setAttribute("usuarioLogado", usuarioLogado);
            FacesUtil.addMsgInfo("Autenticado com sucesso!");
            redireciona("/SIJUD/index.xhtml");
        } else {
            FacesUtil.addMsgError("Email/Usuário ou Senha incorretos!");
        }
        return null;
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void redireciona(String url) {
        RedirecionaPages.redirectToPage(url);
    }

    public String fowardPage(String url) {
        return url;
    }

    public static class UsuarioLogado implements Serializable {

        private Papel papel = Papel.USUARIO_SIMPLES;
        private String nome = "";
        private Boolean logado = false;
        private Date ultimoAcesso;

        public UsuarioLogado(Papel papel, String nome, Boolean logado,Date ultimoAcesso) {
            this.logado = logado;
            this.nome = nome;
            this.papel = papel;
            this.ultimoAcesso = ultimoAcesso;
        }

        public Papel getPapel() {
            return papel;
        }

        public void setPapel(Papel papel) {
            this.papel = papel;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Boolean getLogado() {
            return logado;
        }

        public void setLogado(Boolean logado) {
            this.logado = logado;
        }

        public Date getUltimoAcesso() {
            return ultimoAcesso;
        }

        public void setUltimoAcesso(Date ultimoAcesso) {
            this.ultimoAcesso = ultimoAcesso;
        }

    }
}
