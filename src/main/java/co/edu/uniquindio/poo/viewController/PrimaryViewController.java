package co.edu.uniquindio.poo.viewController;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryViewController {
    App app;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Txt_Bienvenida;

    @FXML
    private Label Txt_NombreEmpresa;

    @FXML
    private Button btn_crudVehiculos;

    @FXML
    private Button btn_crudAlquileres;

    @FXML
    private Button btn_crudClientes;

    @FXML
    void abrrGestionarClientesAction(ActionEvent event) {
        app.openCrudGestionarClientes();
    }

    @FXML
    void abrirGestionarVehiculosAction(ActionEvent event) {
        app.openCrudGestionarVehiculos();
    }

    @FXML
    void abrirGestionarAlquileresAction(ActionEvent event) {
        app.openCrudGestionarAlquileres();
    }

    @FXML
    void initialize() {
        assert Txt_Bienvenida != null : "fx:id=\"Txt_Bienvenida\" was not injected: check your FXML file 'primary.fxml'.";
        assert Txt_NombreEmpresa != null : "fx:id=\"Txt_NombreEmpresa\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn_crudVehiculos != null : "fx:id=\"btn_crudVehiculos\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn_crudAlquileres != null : "fx:id=\"btn_crudAlquileres\" was not injected: check your FXML file 'primary.fxml'.";
        assert btn_crudClientes != null : "fx:id=\"btn_crudClientes\" was not injected: check your FXML file 'primary.fxml'.";

    }
    public void setApp(App app) {
        this.app = app;
    }
}
