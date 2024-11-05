package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    private String NumeroMatrícula;
    private String Marca; 
    private int Modelo; 
    private int AñoFabricación;
    protected static final double TARIFA_BASE = 1000.0;
    private Reserva reserva;
    public Vehiculo(String numeroMatrícula, String marca, int modelo, int añoFabricación) {
        NumeroMatrícula = numeroMatrícula;
        Marca = marca;
        Modelo = modelo;
        AñoFabricación = añoFabricación;
    }
    
    public String getNumeroMatrícula() {
        return NumeroMatrícula;
    }
    public void setNumeroMatrícula(String numeroMatrícula) {
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
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    
    public abstract double calcularCosto(int dias);

    @Override
    public String toString() {
        return "Vehiculo [NumeroMatrícula=" + NumeroMatrícula + ", Marca=" + Marca + ", Modelo=" + Modelo
                + ", AñoFabricación=" + AñoFabricación +"]";
    }    
    
}
