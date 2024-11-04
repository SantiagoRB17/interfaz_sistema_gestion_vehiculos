package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.viewController.PrimaryViewController;
import co.edu.uniquindio.poo.model.Reserva;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    public static Empresa empresa= new Empresa("RentaCar");

    public static Empresa getEmpresa() {
        return empresa;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de alquileres");
        primaryStage.show();
    }

    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("co/edu/uniquindio/poo/primary.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch();

       /*Crear vehiculo */
       Vehiculo carro1=new Auto(4567, "Ford", 2024, 2023, 3000, 4);
       /*Agregar Vehiculo */ 
       empresa.agregarVehiculo(carro1);
       /*Crear cliente */
       Cliente cliente1=new Cliente("Pedro", "10934623", 32459123, "Cra 24# 23-23");
       /*Agregar cliente */
       empresa.agregarCliente(cliente1);
       /*Crear reserva */
       Reserva reserva1=new Reserva(5, 3245, carro1, cliente1);
       /*Metodos agregar*/
       empresa.agregarReserva(reserva1); 
       /*Asociar reserva */
       carro1.setReserva(reserva1);
    }

}