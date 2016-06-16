/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.bean;

import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import br.com.sijud.util.RedirecionaPages;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author renat_dvxxuhs
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean {

    private Usuario usuario;
    
    @PostConstruct
    public void init(){
    usuario = new Usuario();
    usuario.setPessoa(new Pessoa());
    }

    public void autenticar(){
       
        
        
        redireciona("/index");
    
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void redireciona(String url){
    RedirecionaPages.redirectToPage(url);
    }
    
}
