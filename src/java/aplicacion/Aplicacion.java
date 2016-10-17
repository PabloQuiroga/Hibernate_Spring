package aplicacion;

import dao.UsuarioDAO;
import java.util.List;
import org.hibernate.Session;
import pojos.Usuario;
import util.HibernateUtil;

/**
 * @author Pablo Daniel Quiroga
 */
public class Aplicacion {
    public static void main(String[] args) {
//        Usuario u = new Usuario();
//        u.setMail("jtdoe78@hotmail.com");
//        u.setNombre("Pablo hotmail");
//        u.setPass("Lujiweso9deMayo");
//        
//        //get session
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        //start transaction
//        session.beginTransaction();
//        //save the object
//            //session.save(u);
//        
//        //commit transaction
//        session.getTransaction().commit();
//        System.out.println("Usuario id: " + u.getMail());
//        
//        //terminate session factory
//        HibernateUtil.getSessionFactory().close();


        UsuarioDAO ud = new UsuarioDAO();
        List<Usuario> lista = ud.obtenerListado();
        System.out.println("Listado de usuarios...");
        for(Usuario elemento: lista){
            System.out.println(elemento.toString());
        }
    }
}
