/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.dao;

import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import org.junit.Test;

/**
 *
 * @author renat_dvxxuhs
 */
public class UsuarioDaoTest {

    @Test
    public void testSalvarUsuario() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("renatotpvieira@gmail.com.br");
        pessoa.setFirstName("Renato");
        pessoa.setLastName("Vieira");

        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoaFind = pessoaDao.buscarPessoaEmail(pessoa.getEmail());

        if (pessoaFind.getId() == null) {

            pessoaDao.salvar(pessoa);
            pessoaFind = pessoaDao.buscarPessoaEmail(pessoa.getEmail());
            Usuario usuario = new Usuario();
            usuario.setPessoa(pessoaFind);
            usuario.setLogin(pessoa.getEmail());
            usuario.setPwd("123456");
            usuario.setActive(true);

            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.saveOrUpdate(usuario);
        } else {

            System.out.println("Já exite um usuário com esse email!! - " + pessoa.getEmail());
        }
    }

}
