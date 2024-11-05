package co.edu.uniquindio.poo.model;

public class Cliente {
    private String Nombre;
    private String Cedula;
    private int Telefono;
    private String Direccion;
    
    public Cliente(String nombre, String cedula, int telefono, String direccion) {
        Nombre = nombre;
        Cedula = cedula;
        Telefono = telefono;
        Direccion = direccion;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    public int getTelefono() {
        return Telefono;
    }
    public void setTelefono(int telefono) {
        Telefono = telefono;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente [Nombre=" + Nombre + ", Cedula=" + Cedula + ", Telefono=" + Telefono + ", Direccion="
                + Direccion + "]";
    }
    
}
