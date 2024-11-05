package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    int NumPuertas;

    public Auto(int numeroMatrícula, String marca, int modelo, int añoFabricación, double tarifaBase, int numPuertas) {
        super(numeroMatrícula, marca, modelo, añoFabricación, tarifaBase);
        NumPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return NumPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        NumPuertas = numPuertas;
    }
    

    @Override
    public double calcularCosto() {
        Reserva reserva=getReserva();
        int dias=reserva.getDiasReserva();
        return TARIFA_BASE*dias;
    }

    @Override
    public String toString() {
        return "Auto [NumPuertas=" + NumPuertas + super.toString()+"]";
    }
    
}
