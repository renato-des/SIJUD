/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.main;

import br.com.sijud.util.HibernateUtil;

/**
 *
 * @author renat_dvxxuhs
 */
public class GeraTabelas {
    public static void main(String[] args){
    
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
    
}
