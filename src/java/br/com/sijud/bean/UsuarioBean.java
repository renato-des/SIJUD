/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.bean;

import br.com.sijud.dao.PessoaDao;
import br.com.sijud.dao.UsuarioDAO;
import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import br.com.sijud.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author renat_dvxxuhs
 */
@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class UsuarioBean implements Serializable {

    private static final Logger log = Logger.getLogger(UsuarioBean.class.getName());
    private String valorParaExibir;
    private static final String URL = "/cad-pessoa";

    private Usuario usuario;
    private Pessoa pessoa;
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Pessoa getPessoa() {
        if (pessoa == null) {
            pessoa = new Pessoa();
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    private List<Usuario> usuarios;

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String salvarUsuario() {
        UsuarioDAO uDao = new UsuarioDAO();

        if (uDao.existPorCampo("login", usuario.getLogin())) {

            return null;
//            implementar mensagem

        } else {
            PessoaDao pDao = new PessoaDao();
            if (pDao.existPorCampo("email", usuario.getLogin())) {
                pessoa = pDao.buscarPorCampo("email", usuario.getLogin());
                usuario.setActive(false);
                usuario.setPessoa(pessoa);
                uDao.salvar(usuario);
                return "index";
            } else {
                this.setValorParaExibir(usuario.getLogin());
                redirecionaComFlash();
                return "cad-pessoa";
            }
        }
    }

    public void redirecionaComFlash() {

        FacesContext instance = FacesContext.getCurrentInstance();
        ExternalContext externalContext = instance.getExternalContext();
        externalContext.getFlash().put("valorParaExibir", valorParaExibir);

    }

    @PostConstruct
    public void listar() {
        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            usuarios = usuarioDao.listar();
        } catch (RuntimeException erro) {
            FacesUtil.addMsgError("Ocorreu um erro ao listar os usuários");
        }
    }

    public String getValorParaExibir() {
        return valorParaExibir;
    }

    public void setValorParaExibir(String valorParaExibir) {
        this.valorParaExibir = valorParaExibir;
    }

}
