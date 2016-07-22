package br.com.sijud.dao;

/**
 *
 * @author renat_dvxxuhs
 */
import br.com.sijud.model.Usuario;
import br.com.sijud.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsuarioDAO extends GenericDao<Usuario> {

    public Boolean autenticarUsuario(String usuario, String senha) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {

            Criteria consulta = sessao.createCriteria(Usuario.class);
            consulta.add(Restrictions.eq("login", usuario));
            Usuario resultado = (Usuario) consulta.uniqueResult();

            if (resultado != null) {
                if (resultado.getLogin().equals(usuario) && resultado.getPwd().equals(senha)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
}
