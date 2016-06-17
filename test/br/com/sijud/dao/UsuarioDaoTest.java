/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.dao;

import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author renat_dvxxuhs
 */
public class UsuarioDaoTest {

    private static final Logger logger = LogManager.getLogger(UsuarioDaoTest.class);

    @Test
    @Ignore
    public void testSalvarUsuario() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("renatotpvieira.doc@gmail.com");
        pessoa.setFirstName("Renato");
        pessoa.setLastName("Vieira");

        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoaFind = pessoaDao.buscarPorCampo("email", pessoa.getEmail());

        if (pessoaFind == null) {

            pessoaDao.salvar(pessoa);
            pessoaFind = pessoaDao.buscarPorCampo("email", pessoa.getEmail());
            Usuario usuario = new Usuario();
            usuario.setPessoa(pessoaFind);
            usuario.setLogin(pessoa.getEmail());
            usuario.setPwd("123456");
            usuario.setActive(true);

            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.salvar(usuario);

            logger.debug("Usuário cadastrado com sucesso " + usuario.getLogin());
        } else {

            System.out.println("Já exite um usuário com esse email!! - " + pessoa.getEmail());
        }
    }

    @Test
    public void listar() {
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> lista = usuarioDao.listar();
        for (Usuario usuarios : lista) {
            System.out.println(usuarios.getId());
            System.out.println(usuarios.getLogin());
        }

    }
}
