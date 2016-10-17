package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Usuario;
import util.HibernateUtil;

/**
 * @author Pablo Daniel Quiroga
 */
public class UsuarioDAO {
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
    public static Usuario leer(String id){
        Usuario u = null;
    
        iniciar();
        try{
            u = (Usuario) session.get(Usuario.class, id);
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
        try{
            listado = session.createQuery("SELECT u FROM Usuario u").list();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return listado;
    }
}
