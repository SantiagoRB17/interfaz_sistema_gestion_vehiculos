package co.edu.uniquindio.poo.model;

public class Reserva {
    private int DiasReserva;
    private int codigo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private double costoTotal;

    public Reserva(int diasReserva, int codigo, Vehiculo vehiculo, Cliente cliente) {
        DiasReserva = diasReserva;
        this.vehiculo=vehiculo;
        this.cliente=cliente;
        this.codigo=codigo;
        this.costoTotal=vehiculo.calcularCosto(diasReserva);
    }


    

    public int getDiasReserva() {
        return DiasReserva;
    }

    public void setDiasReserva(int diasReserva) {
        DiasReserva = diasReserva;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Reserva [DiasReserva=" + DiasReserva + ", codigo=" + codigo + ", vehiculo=" + vehiculo + ", cliente="
                + cliente + "]";
    }



    public double getCostoTotal() {
        return costoTotal;
    }



    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
   
}
