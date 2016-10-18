package pojos;

/**
 * @author Pablo Daniel Quiroga
 */
public class Usuario {
    private String mail;
    private String nombre;
    private String pass;
    private String tipo;
    
    public Usuario(){}
    public Usuario(String mail, String psw){
        this.mail = mail;
        this.pass = psw;
    }
    
    public void setMail(String x){
        this.mail = x;
    }
    public void setNombre(String x){
        this.nombre = x;
    }
    public void setPass(String x){
        this.pass =  x;
    }
    public void setTipo(String x){
        this.tipo = x;
    }
    public String getMail(){
        return mail;
    }
    public String getNombre(){
        return nombre;
    }
    public String getPass(){
        return pass;
    }
    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return getNombre() + ", " + getMail() + ", " + getPass() + " tipo: " + getTipo();
    }
    
    
}
