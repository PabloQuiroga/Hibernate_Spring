package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Usuario;
import util.HibernateUtil;

/**
 * @author Pablo Daniel Quiroga
 */
public class UsuarioDAO{
    private static Session session;
    
    private static void iniciar(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
    }
    private static void terminar(){
        HibernateUtil.getSessionFactory().close();
    }
    private static void manejaException(HibernateException e){
        session.getTransaction().rollback();
        System.out.println("Error en la capa de acceso a datos\n" + e.getMessage());
        terminar();
    }
    
    public static void guardar(Usuario u){
        iniciar();
        try{
            session.save(u);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static Usuario leer(String email){
        Usuario u = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_USUARIO_BY_MAIL");
        query.setString("mail", email);
        try{
            u = (Usuario) query.uniqueResult();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return u;
    }
    public static void actualizar(Usuario u){
        iniciar();
        try{
            session.update(u);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static void borrar(Usuario u){
        iniciar();
        try{
            session.delete(u);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static void guardar_o_actualizar(Usuario u){
        iniciar();
        try{
            session.saveOrUpdate(u);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static List<Usuario> obtenerListado(){
        List<Usuario> listado = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_ALL_USUARIOS");
        try{
            listado = query.list();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return listado;
    }
    public static List<Usuario> busquedaPorNombre(String nick){
        List<Usuario> listado = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_USUARIO_BY_NOMBRE");
        query.setString("nombre", nick);
        try{
            listado = query.list();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return listado;
    }
    public static List<Usuario> busquedaPorTipo(String type){
        List<Usuario> listado = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_USUARIO_BY_TIPO");
        query.setString("tipo", type);
        try{
            listado = query.list();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return listado;
    }
}
