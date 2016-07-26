/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.dao;

import br.com.sijud.model.Pessoa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author c082401
 */
public class PessoaDAOTest {

    private static final Logger logger = LogManager.getLogger(PessoaDAOTest.class);

    @Test
    @Ignore
    public void testSalvarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setFirstName("Renato");
        pessoa.setLastName("vieira");
        pessoa.setEmail("renato.vieira@gmail.com");
        pessoa.setCpf("16204283855");

        PessoaDAO pessoaDao = new PessoaDAO();
        pessoaDao.salvar(pessoa);

    }

    @Test
    //@Ignore
    public void testLocalizaEmail() {
        String email = "renatotpvieira@gmail.com1";
        Pessoa pessoa = new Pessoa();
        //pessoa.setEmail("renatotpvieira@gmail.com");
        PessoaDAO pessoaDao = new PessoaDAO();
        pessoa = pessoaDao.buscarPorCampo("email", email);
        
        logger.debug("Pessoa - " + pessoa);
    

 //{
//        if(pessoaDao.buscarPorCampo("email", email)!=null){ 
//            Pessoa pessoa = pessoaDao.buscarPorCampo("email", email);
//            logger.debug("teste log4j2 " + email);
//            System.out.println("Pessoa localizada id " + pessoa.getId() + " - " + pessoa.getEmail());
//       } else {
//            System.out.println("Não localizado Pessoa com email : " + email);
//       }

    }

}
