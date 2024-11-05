package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Vehiculo;

public class VehiculoController {
    Empresa empresa;

    public VehiculoController(Empresa empresa) {
        this.empresa = empresa;
    }
    public boolean crearVehiculo(Vehiculo vehiculo) {
        return empresa.agregarVehiculo(vehiculo);
    }
    public Collection<Vehiculo> obtenerListaVehiculos() {
        return empresa.getVehiculos();
    }
    public boolean eliminarVehiculo(String numeroMatrícula) {
        return empresa.eliminarVehiculo(numeroMatrícula);
     }
    public boolean actualizarVehiculo(String numeroMatrícula, Vehiculo vehiculo) {
        return empresa.actualizarVehiculo(numeroMatrícula, vehiculo);
    }
}

