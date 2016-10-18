package pojos;

import java.io.Serializable;

/**
 * @author Pablo Daniel Quiroga
 */
public class Producto implements Serializable{
    private String nombre;
    private String tipo;
    private String unidad_venta;
    private float precio;
    private int codigo;
    private int cantidad;
    
    public Producto(){}
    
    public void setNombre(String x){
        this.nombre = x;
    }
    public void setTipo(String x){
        this.tipo = x;
    }
    public void setUnidad_venta(String x){
        this.unidad_venta = x;
    }
    public void setPrecio(float x){
        this.precio = x;
    }
    public void setCodigo(int x){
        this.codigo = x;
    }
    public void setCantidad(int x){
        this.cantidad = x;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public String getUnidad_venta(){
        return unidad_venta;
    }
    public float getPrecio(){
        return precio;
    }
    public int getCodigo(){
        return codigo;
    }
    public int getCantidad(){
        return cantidad;
    }

    @Override
    public String toString() {
        return "COdigo: " + getCodigo() + ", producto: " + getNombre()
                + " cantidad: " + getCantidad() + " unidades.";
    }
    
    
}
