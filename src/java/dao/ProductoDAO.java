package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Producto;
import pojos.Usuario;
import util.HibernateUtil;

/**
 * @author Pablo Daniel Quiroga
 */
public class ProductoDAO {
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
    
    public static void guardar(Producto p){
        iniciar();
        try{
            session.save(p);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static Producto leer(int cod){
        Producto p = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_PRODUCTO_BY_CODIGO");
        query.setInteger("codigo", cod);
        try{
            p = (Producto) query.uniqueResult();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return p;
    }
    public static void actualizar(Producto p){
        iniciar();
        try{
            session.update(p);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static void borrar(Producto p){
        iniciar();
        try{
            session.delete(p);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static void guardar_o_actualizar(Producto p){
        iniciar();
        try{
            session.saveOrUpdate(p);
            session.getTransaction().commit();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
    }
    public static List<Producto> obtenerListado(){
        List<Producto> listado = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_ALL PRODUCTOS");
        try{
            listado = query.list();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return listado;
    }
    public static List<Producto> busquedaPorNombre(String name){
        List<Producto> listado = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_PRODUCTO_BY_NOMBRE");
        query.setString("nombre", name);
        try{
            listado = query.list();
            terminar();
        }catch(HibernateException ex){
            manejaException(ex);
        }
        return listado;
    }
    public static List<Producto> busquedaPorTipo(String type){
        List<Producto> listado = null;
        
        iniciar();
        Query query = session.getNamedQuery("GET_PRODUCTO_BY_TIPO");
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
