package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private LinkedList <Vehiculo> vehiculos;
    private LinkedList <Cliente> clientes;
    private LinkedList <Reserva> reservas;

    /**
     * Metodo constructor de la clase empresa
     * @param nombre nombre de la empresa
     */

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos=new LinkedList<>();
        this.clientes=new LinkedList<>();
        this.reservas=new LinkedList<>();
    }

    /**
     * Metodo para obtener nombre de la clase empresa
     * @return
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo para modificar el nombre de la clase empresa
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la lista de vehiculos
     * @return
     */
    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Metodo para modificar la lista de vehiculos
     * @param vehiculos
     */
    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Metodo que verifica si un cliente existe en la lista de clientes
     * @param cedula cedula del cliente
     * @return falso en caso de que no existe, verdadero en caso de que exista
     */
    public boolean verificarCliente(String cedula){
        boolean centinela=false;
        for (Cliente cliente : clientes){
            if (cliente.getCedula().equals(cedula)){
                centinela=true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un cliente a la lista de clientes
     * @param cliente cliente a agregar
     */
    public void agregarCliente(Cliente cliente){
        if(!verificarCliente(cliente.getCedula())){
            clientes.add(cliente);
        }
    }

    /**
     * Metodo para eliminar un cliente de la lista de clientes
     * @param cedula cedula del cliente a eliminar
     */
    public void eliminarCliente(String cedula){
        for (Cliente cliente : clientes){
            if(cliente.getCedula().equals(cedula)){
                clientes.remove(cliente);
                break;
            }
        }
    }

    /**
     * Metodo que verifica si un vehiculo existe en la lista de vehiculos
     * @param NumeroMatrícula matricula del vehiculo
     * @return falso en caso de que no existe, verdadero en caso de que exista
     */
    public boolean verificarVehiculo(int NumeroMatrícula){
        boolean centinela=false;
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getNumeroMatrícula()==(NumeroMatrícula)){
                centinela=true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un vehiculo a la lista de vehiculos
     * @param vehiculo vehiculo a agregar
     */
    public void agregarVehiculo(Vehiculo vehiculo){
        if(!verificarVehiculo(vehiculo.getNumeroMatrícula())){
            vehiculos.add(vehiculo);
        }
    }

    /**
     * Metodo para eliminar un vehiculo de la lista de vehiculos
     * @param numeroMatrícula matricula del vehiculo a eliminar
     */
    public void eliminarVehiculo(int numeroMatrícula){
        for (Vehiculo vehiculo : vehiculos){
            if(vehiculo.getNumeroMatrícula()==numeroMatrícula){
                vehiculos.remove(vehiculo);
                break;
            }
        }
    }

   /**
    * Metodo que verifica si una reserva existe en la lista de reservas
    * @param codigo codigo de la reserva
    * @return falso en caso de que no existe, verdadero en caso de que exista
    */
    public boolean verificarReserva(int codigo){
        boolean centinela=false;
        for (Reserva reserva : reservas){
            if (reserva.getCodigo()==codigo){
                centinela=true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar una reserva a la lista de reservas
     * @param reserva reserva a agregar
     */
    public void agregarReserva(Reserva reserva){
        if(!verificarReserva(reserva.getCodigo())){
            reservas.add(reserva);
        }
    }

    /**
     * Metodo para eliminar una reserva de la lista de reservas
     * @param codigo codigo de la reserva a eliminar
     */
    public void eliminarReserva(int codigo){
        for (Reserva reserva : reservas){
            if(reserva.getCodigo()==codigo){
                reservas.remove(reserva);
                break;
            }
        }
    }


    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + ", vehiculos=" + vehiculos + ", clientes=" + clientes + ", reservas="
                + reservas + "]";
    }

}
