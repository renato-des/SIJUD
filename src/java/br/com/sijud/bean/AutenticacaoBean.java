/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.bean;

import br.com.sijud.dao.UsuarioDAO;
import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import br.com.sijud.util.FacesUtil;
import br.com.sijud.util.RedirecionaPages;
import br.com.sijud.util.SessionContext;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author renat_dvxxuhs
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {

    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        Pessoa pessoa = new Pessoa();
        usuario.setPessoa(pessoa);
    }

    public String autenticar() {
        UsuarioDAO usrDAO = new UsuarioDAO();

        //System.out.println("usuario = " + usuario.getLogin() + "senha = " + usuario.getPwd());
        if (usrDAO.autenticarUsuario(usuario.getLogin(), usuario.getPwd())) {
            SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
            redireciona("/SIJUD/index.xhtml");
            FacesUtil.addMsgInfo("Autenticado com sucesso!");
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

}
