package co.edu.uniquindio.poo.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.AlquilerController;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AlquileresViewController {
    App app;
    AlquilerController alquilerController;
    private ObservableList<Reserva> reservas = FXCollections.observableArrayList();
    Reserva selectedAlquiler;
    private void cargarClientes() {
        cmb_cliente.setItems(FXCollections.observableArrayList(app.empresa.getClientes()));
    }
    private void cargarVehiculos() {
        cmb_vehiculo.setItems(FXCollections.observableArrayList(app.empresa.getVehiculos()));
    }
    @FXML
    private Button btn_irAVehiculos;

    @FXML
    private Button btn_irAClientes;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txf_diasAlquiler;

    @FXML
    private ComboBox<Vehiculo> cmb_vehiculo;

    @FXML
    private TextField txf_codigo;

    @FXML
    private TableColumn<Reserva, String> cl_clienteCedula;

    @FXML
    private Button btn_agregarAlquiler;

    @FXML
    private TableColumn<Reserva, Integer> cl_codigo;

    @FXML
    private ComboBox<Cliente> cmb_cliente;

    @FXML
    private Button btn_eliminarAlquiler;

    @FXML
    private TableColumn<Reserva, Integer> cl_dias;

    @FXML
    private Button btn_editarAlquiler;

    @FXML
    private TableView<Reserva> tb_listAlquileres;

    @FXML
    private TableColumn<Reserva, String> cl_VehiculoMatricula;

    @FXML
    private Button btn_limpiar;

    @FXML
    void agregarAlquilerAction(ActionEvent event) {
        agregarAlquiler();
    }

    @FXML
    void eliminarAlquilerAction(ActionEvent event) {
        eliminarAlquiler();
    }

    @FXML
    void editarAlquilerAction(ActionEvent event) {
        actualizarAlquiler();
    }

    @FXML
    void limpiarAction(ActionEvent event) {
        limpiarSeleccion();
    }
    
    @FXML
    void irAVehiculosAction(ActionEvent event) {
        app.openCrudGestionarVehiculos();
    }

    @FXML
    void irAClientesAction(ActionEvent event) {
        app.openCrudGestionarClientes();
    }

    @FXML
    void initialize() {
        assert txf_diasAlquiler != null : "fx:id=\"txf_diasAlquiler\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert cmb_vehiculo != null : "fx:id=\"cmb_vehiculo\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert txf_codigo != null : "fx:id=\"txf_codigo\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert cl_clienteCedula != null : "fx:id=\"cl_clienteCedula\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert btn_agregarAlquiler != null : "fx:id=\"btn_agregarAlquiler\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert cl_codigo != null : "fx:id=\"cl_codigo\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert cmb_cliente != null : "fx:id=\"cmb_cliente\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert btn_eliminarAlquiler != null : "fx:id=\"btn_eliminarAlquiler\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert cl_dias != null : "fx:id=\"cl_dias\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert btn_editarAlquiler != null : "fx:id=\"btn_editarAlquiler\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert tb_listAlquileres != null : "fx:id=\"tb_listAlquileres\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert cl_VehiculoMatricula != null : "fx:id=\"cl_VehiculoMatricula\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        assert btn_limpiar != null : "fx:id=\"btn_limpiar\" was not injected: check your FXML file 'crudAlquileres.fxml'.";
        alquilerController= new AlquilerController(app.empresa);
        cargarClientes();
        cargarVehiculos();
        initView();
    }
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerAlquileres();

        // Limpiar la tabla
        tb_listAlquileres.getItems().clear();

        // Agregar los elementos a la tabla
        tb_listAlquileres.setItems(reservas);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }
    private void initDataBinding() {
        cl_clienteCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getCedula()));
        cl_VehiculoMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getNumeroMatrícula()));
        cl_dias.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDiasReserva()));
        cl_codigo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCodigo()));
    }
    private void obtenerAlquileres() {
        reservas.addAll(alquilerController.obtenerListaAlquileres());
    }
    private void listenerSelection() {
        tb_listAlquileres.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {selectedAlquiler = newSelection;mostrarInformacionAlquiler(selectedAlquiler);});
    }
    private void mostrarInformacionAlquiler(Reserva alquiler) {
        if (alquiler != null) {
            txf_codigo.setText(String.valueOf(alquiler.getCodigo()));
            txf_diasAlquiler.setText(String.valueOf(alquiler.getDiasReserva()));
        }
        Cliente cliente = alquiler.getCliente();
        if (cliente != null) {
            cmb_cliente.setValue(cliente); 
        }
        Vehiculo vehiculo = alquiler.getVehiculo();
        if (vehiculo != null) {
            cmb_vehiculo.setValue(vehiculo); 
        }
    }
    private void agregarAlquiler() {
        Reserva alquiler = buildAlquiler();
        if (alquilerController.crearAlquiler(alquiler)) {
            reservas.add(alquiler);
            limpiarCamposAlquiler();
        }
    }
    private Reserva buildAlquiler() {
        Cliente clienteSeleccionado = cmb_cliente.getSelectionModel().getSelectedItem();
        Vehiculo vehiculoSeleccionado = cmb_vehiculo.getSelectionModel().getSelectedItem();
       Reserva alquiler = new Reserva(Integer.parseInt(txf_diasAlquiler.getText()),Integer.parseInt(txf_codigo.getText()) , vehiculoSeleccionado, clienteSeleccionado);
        return alquiler;
    }
    private void eliminarAlquiler() {
        if (alquilerController.eliminarAlquiler(Integer.parseInt(txf_codigo.getText()))) {
            reservas.remove(selectedAlquiler);
            limpiarCamposAlquiler();
            limpiarSeleccion();
        }
    }
    private void actualizarAlquiler() {

        if (selectedAlquiler != null &&
                alquilerController.actualizarAlquiler(selectedAlquiler.getCodigo(), buildAlquiler())) {

            int index = reservas.indexOf(selectedAlquiler);
            if (index >= 0) {
                reservas.set(index, buildAlquiler());
            }

            tb_listAlquileres.refresh();
            limpiarSeleccion();
            limpiarCamposAlquiler();
        }
    }
    private void limpiarSeleccion() {
        tb_listAlquileres.getSelectionModel().clearSelection();
        limpiarCamposAlquiler();
    }
    private void limpiarCamposAlquiler() {
        txf_codigo.clear();
        txf_diasAlquiler.clear();
        cmb_cliente.getSelectionModel().clearSelection();
        cmb_vehiculo.getSelectionModel().clearSelection();
    }
    
    public void setApp(App app) {
        this.app = app;
    }
}
