/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sijud.dao;

import br.com.sijud.model.Papel;
import br.com.sijud.model.Pessoa;
import br.com.sijud.model.Usuario;
import br.com.sijud.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author renat_dvxxuhs
 */
public class UsuarioDAOTest {

    private static final Logger logger = LogManager.getLogger(UsuarioDAOTest.class);

    @Test
    @Ignore
    public void testUpdateUltimoAcesso() {
        Usuario usuario = new Usuario();
        usuario.setLogin("renatotpvieira@gmail.com");
        usuario.setPwd("32776385");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.autenticarUsuario(usuario.getLogin(), usuario.getPwd());
        usuario.setUltimoAcesso(new Date());
        logger.info("Ultimo Acesso " + usuario.getUltimoAcesso());
        usuarioDAO.updateUltimoAcesso(usuario);
    }

    @Test
    @Ignore
    public void testAutenticarUsuario() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("renatotpvieira@gmail.com");
        pessoa.setFirstName("Renato");
        pessoa.setLastName("Tadeu Prado Vieira");

        Usuario usuario = new Usuario();
        usuario.setPessoa(pessoa);
        usuario.setLogin("renatotpvieira@gmail.com");
        usuario.setPwd("32776385");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usrLogado = usuarioDAO.autenticarUsuario(usuario.getLogin(), usuario.getPwd());
        usrLogado.setPapel(Papel.GERENTE);

        if (usrLogado != null) {
            //System.out.println("Autenticado");
            logger.info("Ele é Papel - " + usrLogado.getPapel());
            logger.info("Ele é Valor Papel - " + usrLogado.getPapel().getValorPapel());
            logger.info("Ele é ADM - " + usrLogado.isAdm());
            logger.info("Ele é GERENTE - " + usrLogado.isGerente());
            logger.info("Ele é USUARIO_SIMPLES - " + usrLogado.isUsuarioSimples());
            logger.info("Logger Autenticado");
        } else {
            //System.out.println("Não Autenticado");
            logger.getLevel().getDeclaringClass();
            logger.debug("Logger Não Autenticado");
        }
    }

    @Test
    @Ignore
    public void testSalvarUsuario() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("renatotpvieira.doc@gmail.com");
        pessoa.setFirstName("Renato");
        pessoa.setLastName("Vieira");

        PessoaDAO pessoaDao = new PessoaDAO();
        Pessoa pessoaFind = pessoaDao.buscarPorCampo("email", pessoa.getEmail());

        if (pessoaFind == null) {

            pessoaDao.salvar(pessoa);
            pessoaFind = pessoaDao.buscarPorCampo("email", pessoa.getEmail());
            Usuario usuario = new Usuario();
            usuario.setPessoa(pessoaFind);
            usuario.setLogin(pessoa.getEmail());
            usuario.setPwd("123456");
            usuario.setActive(true);

            UsuarioDAO usuarioDao = new UsuarioDAO();
            usuarioDao.salvar(usuario);

            logger.debug("Usuário cadastrado com sucesso " + usuario.getLogin());
        } else {

            System.out.println("Já exite um usuário com esse email!! - " + pessoa.getEmail());
        }
    }

    @Test
    @Ignore
    public void listar() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> lista = usuarioDao.listar();
        for (Usuario usuarios : lista) {
            System.out.println(usuarios.getId());
            System.out.println(usuarios.getLogin());
        }

    }

    @Test
//    @Ignore
    public void PessoaUsuarioTest() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.close();

    }
}