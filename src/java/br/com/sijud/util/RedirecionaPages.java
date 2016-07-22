/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.util;

import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author renat_dvxxuhs
 */
public class RedirecionaPages {

    public static void redirectToPage(String toUrl) {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();

            ExternalContext extContext = ctx.getExternalContext();
            String url = extContext.encodeActionURL(ctx.getApplication().
                    getViewHandler().getActionURL(ctx, toUrl));

            extContext.redirect(url);
        } catch (IOException e) {
            throw new FacesException(e);
        }
    }
    
}
