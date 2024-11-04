package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    int NumeroMatrícula;
    String Marca; 
    int Modelo; 
    int AñoFabricación;
    double TarifaBase;
    private Reserva reserva;
    public Vehiculo(int numeroMatrícula, String marca, int modelo, int añoFabricación, double tarifaBase) {
        NumeroMatrícula = numeroMatrícula;
        Marca = marca;
        Modelo = modelo;
        AñoFabricación = añoFabricación;
        TarifaBase = tarifaBase;
        
    }
    
    public int getNumeroMatrícula() {
        return NumeroMatrícula;
    }
    public void setNumeroMatrícula(int numeroMatrícula) {
        NumeroMatrícula = numeroMatrícula;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public int getModelo() {
        return Modelo;
    }
    public void setModelo(int modelo) {
        Modelo = modelo;
    }
    public int getAñoFabricación() {
        return AñoFabricación;
    }
    public void setAñoFabricación(int añoFabricación) {
        AñoFabricación = añoFabricación;
    }
    public double getTarifaBase() {
        return TarifaBase;
    }
    public void setTarifaBase(double tarifaBase) {
        TarifaBase = tarifaBase;
    }
    
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    
    public abstract void calcularCosto();

    @Override
    public String toString() {
        return "Vehiculo [NumeroMatrícula=" + NumeroMatrícula + ", Marca=" + Marca + ", Modelo=" + Modelo
                + ", AñoFabricación=" + AñoFabricación + ", TarifaBase=" + TarifaBase + "]";
    }    
    
}
