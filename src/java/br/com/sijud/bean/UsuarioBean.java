/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.bean;

import br.com.sijud.dao.UsuarioDao;
import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author renat_dvxxuhs
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    private Pessoa pessoa;
   
    public UsuarioBean() {
        if(this.usuario==null){
        usuario = new Usuario();
        }
        if(this.pessoa==null){
        pessoa = new Pessoa();
        }
    }

    public void salvarUsuario(){
        UsuarioDao usuarioDao = new UsuarioDao();
        usuario.setPessoa(pessoa);
        usuarioDao.salvar(usuario);
                
        
    
    }
    
    public List<Usuario> getUsuarioList() {
        UsuarioDao usuarioDao = new UsuarioDao();

        return usuarioDao.listar();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    

}
