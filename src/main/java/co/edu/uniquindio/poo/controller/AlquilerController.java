package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;

public class AlquilerController {
    Empresa empresa;

    public AlquilerController(Empresa empresa) {
        this.empresa = empresa;
    }
    public boolean crearAlquiler(Reserva reserva) {
        return empresa.agregarReserva(reserva);
    }
    public Collection<Reserva> obtenerListaAlquileres() {
        return empresa.getReservas();
    }
    public boolean eliminarAlquiler(int codigo) {
        return empresa.eliminarReserva(codigo);
     }
    public boolean actualizarAlquiler(int codigo, Reserva alquiler) {
        return empresa.actualizarReserva(codigo, alquiler);
    }
}
    
