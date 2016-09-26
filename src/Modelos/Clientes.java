package Modelos;
// Generated 26-sep-2016 11:41:16 by Hibernate Tools 4.3.1



/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private int telefono;
     private String nombre;
     private String apellido;
     private String direccion;

    @Override
    public String toString() {
        return  telefono + "                  " + nombre + "         " + apellido + "                 " + direccion;
    }

    public Clientes() {
    }

	
    public Clientes(int telefono) {
        this.telefono = telefono;
    }
    public Clientes(int telefono, String nombre, String apellido, String direccion) {
       this.telefono = telefono;
       this.nombre = nombre;
       this.apellido = apellido;
       this.direccion = direccion;
    }
   
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }




}


