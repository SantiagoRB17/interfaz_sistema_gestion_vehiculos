package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    boolean EsAutomatica;
    
    public Moto(int numeroMatrícula, String marca, int modelo, int añoFabricación, double tarifaBase,
            boolean esAutomatica) {
        super(numeroMatrícula, marca, modelo, añoFabricación, tarifaBase);
        EsAutomatica = esAutomatica;
    }

    public boolean isEsAutomatica() {
        return EsAutomatica;
    }

    public void setEsAutomatica(boolean esAutomatica) {
        EsAutomatica = esAutomatica;
    }

    

    @Override
    public void calcularCosto() {
        Reserva reserva=getReserva();
        int dias=reserva.getDiasReserva();
        if (EsAutomatica){
            System.out.println(TarifaBase*dias+5000);
        }
        else{
            System.out.println(TarifaBase*dias);
        }
    }

    @Override
    public String toString() {
        return "Moto [EsAutomatica=" + EsAutomatica + super.toString()+"]";
    }
    
}
