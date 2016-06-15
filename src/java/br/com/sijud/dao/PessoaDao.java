/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.dao;

import br.com.sijud.model.Pessoa;
import br.com.sijud.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author c082401
 */
public class PessoaDao extends GenericDao<Pessoa> {

    @SuppressWarnings("unchecked")
    public Pessoa buscarPessoaEmail(String email) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Pessoa.class);
            consulta.add(Restrictions.like("email", email, MatchMode.EXACT));
            Pessoa resultado = (Pessoa) consulta.uniqueResult();
            if (resultado != null) {
                return resultado;
            } else {
                resultado = new Pessoa();
                return resultado;
            }
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
