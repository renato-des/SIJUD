/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.dao;

import br.com.sijud.model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author c082401
 */
public class PessoaDaoTest {

    @Test
    @Ignore
    public void testSalvarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setFirstName("Renato");
        pessoa.setLastName("vieira");
        pessoa.setEmail("renatotpvieira@gmail.com");
        pessoa.setCpf("16204283855");

        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.salvar(pessoa);

    }
    
    @Test
    public void testLocalizaEmail(){
    
        //Pessoa pessoa = new Pessoa();
        //pessoa.setEmail("renatotpvieira@gmail.com");

        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoa = pessoaDao.buscarPessoaEmail("renatotpvieira@gmail.com");
        System.out.println("Pessoa localizada id " + pessoa.getId() + " - " + pessoa.getEmail() );
         
    }

}
