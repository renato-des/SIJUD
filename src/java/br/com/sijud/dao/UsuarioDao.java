package br.com.sijud.dao;

/**
 *
 * @author renat_dvxxuhs
 */
import br.com.sijud.model.Usuario;
import br.com.sijud.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDao {

    public void saveOrUpdate(Usuario usuario) {
     
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction trans = null;
            try {
                //FacesUtil.addMsgError("1" + usuario.getUser());
                trans = session.beginTransaction();
                session.save(usuario);
                trans.commit();
            } catch (RuntimeException ex) {
                if (trans != null) {
                    trans.rollback();
                }
                ex.printStackTrace();
                throw ex;
            } finally {
                session.close();
            }
      
    }

}
