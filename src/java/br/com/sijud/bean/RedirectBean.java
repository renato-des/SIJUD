/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.bean;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author renat_dvxxuhs
 */
@ManagedBean
@RequestScoped
public class RedirectBean {

    /**
     * Creates a new instance of Redirect
     */
    public String redireciona(String sUrl){
        try { 
            FacesContext.getCurrentInstance().getExternalContext().dispatch(sUrl);
        } catch (IOException ex) {
            Logger.getLogger(RedirectBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sUrl;
    }
    
    public String moveToPage(String toUrl){
    return toUrl;
    }
    
}
