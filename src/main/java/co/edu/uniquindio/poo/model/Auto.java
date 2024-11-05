package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    int NumPuertas;

    public Auto(String numeroMatrícula, String marca, int modelo, int añoFabricación, int numPuertas) {
        super(numeroMatrícula, marca, modelo, añoFabricación);
        NumPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return NumPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        NumPuertas = numPuertas;
    }
    

    @Override
    public double calcularCosto(int dias) {
        return TARIFA_BASE*dias;
    }

    @Override
    public String toString() {
        return "Auto [NumPuertas=" + NumPuertas + super.toString()+"]";
    }
    
}
