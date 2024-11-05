package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    boolean EsAutomatica;
    
    public Moto(String numeroMatrícula, String marca, int modelo, int añoFabricación, boolean esAutomatica) {
        super(numeroMatrícula, marca, modelo, añoFabricación);
        EsAutomatica = esAutomatica;
    }

    public boolean isEsAutomatica() {
        return EsAutomatica;
    }

    public void setEsAutomatica(boolean esAutomatica) {
        EsAutomatica = esAutomatica;
    }

    

    @Override
    public double calcularCosto(int dias) {
        if (EsAutomatica){
            return TARIFA_BASE*dias+500;
        }
        else{
            return TARIFA_BASE*dias;
        }
    }

    @Override
    public String toString() {
        return "Moto [EsAutomatica=" + EsAutomatica + super.toString()+"]";
    }
    
}
