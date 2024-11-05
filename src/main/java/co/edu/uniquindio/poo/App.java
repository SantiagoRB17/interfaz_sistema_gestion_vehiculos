package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.viewController.ClientesViewController;
import co.edu.uniquindio.poo.viewController.PrimaryViewController;
import co.edu.uniquindio.poo.model.Reserva;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    @SuppressWarnings("exports")
    public static Empresa empresa= new Empresa("RentaCar");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de alquileres");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch();
    }

    public void openCrudGestionarClientes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudClientes.fxml"));
            SplitPane rootLayout = (SplitPane) loader.load();
            ClientesViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}