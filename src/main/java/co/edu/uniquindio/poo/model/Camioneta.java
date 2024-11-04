package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo{
    double CapacidadToneladas;

    public Camioneta(int numeroMatrícula, String marca, int modelo, int añoFabricación, double tarifaBase,
            double capacidadToneladas) {
        super(numeroMatrícula, marca, modelo, añoFabricación, tarifaBase);
        CapacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {
        return CapacidadToneladas;
    }

    public void setCapacidadToneladas(double capacidadToneladas) {
        CapacidadToneladas = capacidadToneladas;
    }
    
    @Override
    public void calcularCosto() {
        Reserva reserva=getReserva();
        int dias=reserva.getDiasReserva();
        System.out.println(TarifaBase*dias*CapacidadToneladas);
        
    }

    @Override
    public String toString() {
        return "Camioneta [CapacidadToneladas=" + CapacidadToneladas + super.toString()+"]";
    }
    
}
