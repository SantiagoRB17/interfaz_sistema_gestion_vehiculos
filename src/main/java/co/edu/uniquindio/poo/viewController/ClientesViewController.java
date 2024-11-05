package co.edu.uniquindio.poo.viewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ClienteController;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClientesViewController{
    App app;
    ClienteController clienteController;
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;
    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btn_irAVehiculos;

    @FXML
    private Button btn_irAAlquileres;

    @FXML
    private URL location;

    @FXML
    private TableView<Cliente> tb_clientes;

    @FXML
    private Button btn_EliminarCliente;

    @FXML
    private TableColumn<Cliente, String> cl_cedula;

    @FXML
    private Button btn_EditarCliente;

    @FXML
    private TextField input_cedula;

    @FXML
    private Label txt_nombre;

    @FXML
    private TableColumn<Cliente, Long> cl_telefono;

    @FXML
    private Button btn_Limpiar;

    @FXML
    private TextField input_direccion;

    @FXML
    private TableColumn<Cliente, String> cl_nombre;

    @FXML
    private Label txt_cedula;

    @FXML
    private TextField input_nombre;

    @FXML
    private Button btn_agregarCliente;

    @FXML
    private Label Txt_titulo;

    @FXML
    private TableColumn<Cliente, String> cl_direccion;

    @FXML
    private TextField input_telefono;

    @FXML
    private Label txt_direccion;

      @FXML
    void agregarClienteAction(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void eliminarClienteAction(ActionEvent event) {
        eliminarCliente();
    }

    @FXML
    void limparAction(ActionEvent event) {
        limpiarSeleccion();
    }

    @FXML
    void editarClienteAction(ActionEvent event) {
        actualizarCliente();

    
    }
    @FXML
    void irAVehiculosAction(ActionEvent event) {
        app.openCrudGestionarVehiculos();
    }

    @FXML
    void irAAlquileresAction(ActionEvent event) {
        app.openCrudGestionarAlquileres();
    }
    @FXML
    void initialize() {
        assert tb_clientes != null : "fx:id=\"tb_clientes\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert btn_EliminarCliente != null : "fx:id=\"btn_EliminarCliente\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert cl_cedula != null : "fx:id=\"cl_cedula\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert btn_EditarCliente != null : "fx:id=\"btn_EditarCliente\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert input_cedula != null : "fx:id=\"input_cedula\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert cl_telefono != null : "fx:id=\"cl_telefono\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert btn_Limpiar != null : "fx:id=\"btn_Limpiar\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert input_direccion != null : "fx:id=\"input_direccion\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert cl_nombre != null : "fx:id=\"cl_nombre\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert txt_cedula != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert input_nombre != null : "fx:id=\"input_nombre\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert btn_agregarCliente != null : "fx:id=\"btn_agregarCliente\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert Txt_titulo != null : "fx:id=\"Txt_titulo\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert cl_direccion != null : "fx:id=\"cl_direccion\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert input_telefono != null : "fx:id=\"input_telefono\" was not injected: check your FXML file 'crudClientes.fxml'.";
        assert txt_direccion != null : "fx:id=\"txt_direccion\" was not injected: check your FXML file 'crudClientes.fxml'.";
        clienteController = new ClienteController(app.empresa);
        initView();
    }
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerClientes();

        // Limpiar la tabla
        tb_clientes.getItems().clear();

        // Agregar los elementos a la tabla
        tb_clientes.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        cl_cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        cl_nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        cl_telefono.setCellValueFactory(cellData -> new SimpleObjectProperty<Long>(cellData.getValue().getTelefono()));
        cl_direccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerClientes() {
        listClientes.addAll(clienteController.obtenerListaClientes());
    }
    private void listenerSelection() {
        tb_clientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {selectedCliente = newSelection;mostrarInformacionCliente(selectedCliente);});
    }
    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            input_nombre.setText(cliente.getNombre());
            input_cedula.setText(cliente.getCedula());
            input_telefono.setText(String.valueOf(cliente.getTelefono()));
            input_direccion.setText(cliente.getDireccion());
        }
    }
    private void agregarCliente() {
        Cliente cliente = buildCliente();
        if (clienteController.crearCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }
    private Cliente buildCliente() {
        Cliente cliente = new Cliente(input_nombre.getText(), input_cedula.getText(), Long.parseLong(input_telefono.getText()),input_direccion.getText());
        return cliente;
    }
    private void eliminarCliente() {
        if (clienteController.eliminarCliente(input_cedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }
    private void actualizarCliente() {

        if (selectedCliente != null &&
                clienteController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listClientes.set(index, buildCliente());
            }

            tb_clientes.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }

    private void limpiarSeleccion() {
        tb_clientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        input_nombre.clear();
        input_cedula.clear();
        input_telefono.clear();
        input_direccion.clear();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
