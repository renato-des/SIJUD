/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
        return sUrl;
    }
    
    public String moveToPage(String toUrl){
    return toUrl;
    }
    
}
