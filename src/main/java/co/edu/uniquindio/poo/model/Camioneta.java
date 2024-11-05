package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo{
    double CapacidadToneladas;

    public Camioneta(String numeroMatrícula, String marca, int modelo, int añoFabricación,
            double capacidadToneladas) {
        super(numeroMatrícula, marca, modelo, añoFabricación);
        CapacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {
        return CapacidadToneladas;
    }

    public void setCapacidadToneladas(double capacidadToneladas) {
        CapacidadToneladas = capacidadToneladas;
    }
    
    @Override
    public double calcularCosto(int dias) {
        double porcentajeAdicional=0.10*CapacidadToneladas;
        return TARIFA_BASE*dias+porcentajeAdicional;
        
    }

    @Override
    public String toString() {
        return "Camioneta [CapacidadToneladas=" + CapacidadToneladas + super.toString()+"]";
    }
    
}
