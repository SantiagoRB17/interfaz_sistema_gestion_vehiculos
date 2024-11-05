package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.VehiculoController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VehiculosViewController {
    App app;
    VehiculoController vehiculoController;
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    Vehiculo selectedVehiculo;
    @FXML
    private Button btn_irAClientes;

    @FXML
    private Button btn_irAAlquileres;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label txt_marca;

    @FXML
    private Label txt_añofabricacion;

    @FXML
    private Label txt_modelo;

    @FXML
    private TextField txf_marca;

    @FXML
    private TableColumn<Vehiculo, Integer> cl_modelo;

    @FXML
    private Button btn_editarVehiculo;

    @FXML
    private ChoiceBox<String> chb_esautomatica;

    @FXML
    private TextField txf_AñoFabricacion;

    @FXML
    private Label txt_capacidadcarga;

    @FXML
    private Label txt_esautomatica;

    @FXML
    private TableColumn<Vehiculo, String> cl_marca;

    @FXML
    private Button btn_limpiar;

    @FXML
    private TextField txf_NumPuertas;

    @FXML
    private TableColumn<Vehiculo, String> cl_matricula;

    @FXML
    private Label txt_matricula;

    @FXML
    private Label txt_numeropuertas;

    @FXML
    private TableView<Vehiculo> tb_listaVehiculos;

    @FXML
    private ComboBox<String> cmb_TipoVehiculo;

    @FXML
    private TextField txf_matricula;

    @FXML
    private TextField txf_modelo;

    @FXML
    private TableColumn<Vehiculo, Integer> cl_añoFabricacion;

    @FXML
    private Label txt_tipo;

    @FXML
    private TextField txf_CapacidadCarga;

    @FXML
    private Button btn_agregarVehiculo;

    @FXML
    private Button btn_eliminarVehiculo;

    @FXML
    void agregarVehiculoAction(ActionEvent event) {
        agregarVehiculo();
    }

    @FXML
    void eliminarVehiculoAction(ActionEvent event) {
        eliminarVehiculo();
    }

    @FXML
    void editarVehiculoAction(ActionEvent event) {
        editarVehiculo();
    }   

    @FXML
    void limpiarAction(ActionEvent event) {
        limpiarSeleccion();
    }

    @FXML
    void irAAlquileresAction(ActionEvent event) {
        app.openCrudGestionarAlquileres();
    }
    @FXML
    void irAClientesAction(ActionEvent event) {
        app.openCrudGestionarClientes();
    }

    @FXML
    void initialize() {
        assert tb_listaVehiculos != null
                : "fx:id=\"tb_listaVehiculos\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert cmb_TipoVehiculo != null
                : "fx:id=\"cmb_TipoVehiculo\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert txf_marca != null : "fx:id=\"txf_marca\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert txf_matricula != null
                : "fx:id=\"txf_matricula\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert txf_modelo != null : "fx:id=\"txf_modelo\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert cl_modelo != null : "fx:id=\"cl_modelo\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert btn_editarVehiculo != null
                : "fx:id=\"btn_editarVehiculo\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert chb_esautomatica != null
                : "fx:id=\"chb_esautomatica\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert cl_añoFabricacion != null
                : "fx:id=\"cl_añoFabricacion\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert txf_AñoFabricacion != null
                : "fx:id=\"txf_AñoFabricacion\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert cl_marca != null : "fx:id=\"cl_marca\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert txf_CapacidadCarga != null
                : "fx:id=\"txf_CapacidadCarga\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert btn_agregarVehiculo != null
                : "fx:id=\"btn_agregarVehiculo\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert btn_limpiar != null
                : "fx:id=\"btn_limpiar\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert txf_NumPuertas != null
                : "fx:id=\"txf_NumPuertas\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert btn_eliminarVehiculo != null
                : "fx:id=\"btn_eliminarVehiculo\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        assert cl_matricula != null
                : "fx:id=\"cl_matricula\" was not injected: check your FXML file 'crudVehiculos.fxml'.";
        cmb_TipoVehiculo.getItems().addAll("Auto", "Moto", "Camioneta");
        cmb_TipoVehiculo.setOnAction(event -> OpcionesVehiculo());        
        chb_esautomatica.getItems().addAll("Manual", "Automática");
        chb_esautomatica.setValue("Manual");
        vehiculoController = new VehiculoController(app.empresa);
        ocultarCamposVehiculo();
        initView();
    }

    private void OpcionesVehiculo() {
        String seleccionVehiculo = cmb_TipoVehiculo.getValue();
        ocultarCamposVehiculo();
        if (seleccionVehiculo == null) {
            cmb_TipoVehiculo.setDisable(false);
            return; 
        }
        switch (seleccionVehiculo) {
            case "Auto":
                mostrarCamposAuto();
                break;
            case "Camioneta":
                mostrarCamposCamioneta();
                break;
            case "Moto":
                mostrarCamposMoto();
                break;
            default:
                break;
        }
    }
    private void ocultarCamposVehiculo() {
        txf_matricula.setVisible(false);
        txt_matricula.setVisible(false);
        txf_marca.setVisible(false);
        txt_marca.setVisible(false);
        txf_modelo.setVisible(false);
        txt_modelo.setVisible(false);
        txf_AñoFabricacion.setVisible(false);
        txt_añofabricacion.setVisible(false);
        txf_CapacidadCarga.setVisible(false);
        txt_capacidadcarga.setVisible(false);
        txf_NumPuertas.setVisible(false);
        txt_numeropuertas.setVisible(false);
        chb_esautomatica.setVisible(false);
        txt_esautomatica.setVisible(false);
    }
    private void mostrarCamposAuto() {
        txf_matricula.setVisible(true);
        txt_matricula.setVisible(true);
        txf_marca.setVisible(true);
        txt_marca.setVisible(true);
        txf_modelo.setVisible(true);
        txt_modelo.setVisible(true);
        txf_AñoFabricacion.setVisible(true);
        txt_añofabricacion.setVisible(true);
        txf_NumPuertas.setVisible(true);
        txt_numeropuertas.setVisible(true);
    }
    private void mostrarCamposCamioneta() {
        txf_matricula.setVisible(true);
        txt_matricula.setVisible(true);
        txf_marca.setVisible(true);
        txt_marca.setVisible(true);
        txf_modelo.setVisible(true);
        txt_modelo.setVisible(true);
        txf_AñoFabricacion.setVisible(true);
        txt_añofabricacion.setVisible(true);
        txf_CapacidadCarga.setVisible(true);
        txt_capacidadcarga.setVisible(true);
    }
    private void mostrarCamposMoto() {
        txf_matricula.setVisible(true);
        txt_matricula.setVisible(true);
        txf_marca.setVisible(true);
        txt_marca.setVisible(true);
        txf_modelo.setVisible(true);
        txt_modelo.setVisible(true);
        txf_AñoFabricacion.setVisible(true);
        txt_añofabricacion.setVisible(true);
        chb_esautomatica.setVisible(true);
        txt_esautomatica.setVisible(true);
    }
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerVehiculos();

        // Limpiar la tabla
        tb_listaVehiculos.getItems().clear();

        // Agregar los elementos a la tabla
        tb_listaVehiculos.setItems(listVehiculos);

        // Seleccionar elemento de la tabla
        listenerSelection();

    }

    private void initDataBinding() {
        cl_matricula.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumeroMatrícula()));
        cl_marca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        cl_modelo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getModelo()));
        cl_añoFabricacion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAñoFabricación()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }
    
    private void obtenerVehiculos() {
        listVehiculos.addAll(vehiculoController.obtenerListaVehiculos());
    }
    private void listenerSelection() {
        tb_listaVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {selectedVehiculo = newSelection;mostrarInformacionVehiculo(selectedVehiculo);});
    }
    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txf_matricula.setText(vehiculo.getNumeroMatrícula());
            txf_marca.setText(vehiculo.getMarca());
            txf_modelo.setText(String.valueOf(vehiculo.getModelo()));
            txf_AñoFabricacion.setText(String.valueOf(vehiculo.getAñoFabricación()));
            if (vehiculo instanceof Auto) {
                txf_NumPuertas.setText(String.valueOf(((Auto) vehiculo).getNumPuertas()));
                txf_NumPuertas.setVisible(true); // Muestra el campo específico
                chb_esautomatica.setVisible(false);
                txf_CapacidadCarga.setVisible(false);
            } else if (vehiculo instanceof Moto) {
                boolean esAutomatica = ((Moto) vehiculo).isEsAutomatica();
                chb_esautomatica.setValue(esAutomatica ? "Automática" : "Manual");
                chb_esautomatica.setVisible(true);
                txf_NumPuertas.setVisible(false);
                txf_NumPuertas.setVisible(false);
            } else if (vehiculo instanceof Camioneta) {
                txf_CapacidadCarga.setText(String.valueOf(((Camioneta) vehiculo).getCapacidadToneladas()));
                txf_CapacidadCarga.setVisible(true);
                txf_NumPuertas.setVisible(false);
                chb_esautomatica.setVisible(false);
            }
        }
    }
    private void agregarVehiculo() {
        Vehiculo vehiculo = buildVehiculo();
        if (vehiculoController.crearVehiculo(vehiculo) && vehiculo !=null) {
            listVehiculos.add(vehiculo);
            limpiarCamposVehiculo();
        }
    }
    private Vehiculo buildVehiculo() {
        String tipoVehiculo = cmb_TipoVehiculo.getValue();
        int modelo= Integer.parseInt(txf_modelo.getText());
        int añoFabricación= Integer.parseInt(txf_AñoFabricacion.getText());
        switch (tipoVehiculo) {
            case "Auto":
                int puertas = Integer.parseInt(txf_NumPuertas.getText());
                return new Auto(txf_matricula.getText(),txf_marca.getText(),modelo,añoFabricación,puertas);
            case "Moto":
                boolean esAutomatica = chb_esautomatica.getValue().equals("Automática");
                return new Moto(txf_matricula.getText(),txf_marca.getText(),modelo,añoFabricación,esAutomatica);
            case "Camioneta":
                double capacidadCarga = Double.parseDouble(txf_CapacidadCarga.getText());
                return new Camioneta(txf_matricula.getText(),txf_marca.getText(),modelo,añoFabricación, capacidadCarga);
            default:
                return null;
        }
    }
    private void eliminarVehiculo() {
        if (vehiculoController.eliminarVehiculo(txf_matricula.getText())) {
            listVehiculos.remove(selectedVehiculo);
            limpiarCamposVehiculo();
            limpiarCamposVehiculo();
        }
    }
    private void editarVehiculo() {
        if (selectedVehiculo != null) {
            actualizarAtributosVehiculo(selectedVehiculo);
    
            int index = listVehiculos.indexOf(selectedVehiculo);
            if (index >= 0) {
                listVehiculos.set(index, selectedVehiculo); 
                tb_listaVehiculos.refresh();
            }
            
            limpiarSeleccion();
            limpiarCamposVehiculo();
        } else {
            System.out.println("No hay vehículos para editar o no hay selección.");
        }
    }
    private void actualizarAtributosVehiculo(Vehiculo vehiculo) {
        if (!txf_marca.getText().isEmpty()) {
            vehiculo.setMarca(txf_marca.getText());
        }
        if (!txf_modelo.getText().isEmpty()) {
            vehiculo.setModelo(Integer.parseInt(txf_modelo.getText()));
        }
        if (!txf_AñoFabricacion.getText().isEmpty()) {
            vehiculo.setAñoFabricación(Integer.parseInt(txf_AñoFabricacion.getText()));
        }

        if (vehiculo instanceof Auto) {
            if (!txf_NumPuertas.getText().isEmpty()) {
                ((Auto) vehiculo).setNumPuertas(Integer.parseInt(txf_NumPuertas.getText()));
            }
        } else if (vehiculo instanceof Moto) {
            if (chb_esautomatica.getValue() != null) {
                boolean esAutomatica = chb_esautomatica.getValue().equals("Automática");
                ((Moto) vehiculo).setEsAutomatica(esAutomatica);
            }
        } else if (vehiculo instanceof Camioneta) {
            if (!txf_CapacidadCarga.getText().isEmpty()) {
                ((Camioneta) vehiculo).setCapacidadToneladas(Double.parseDouble(txf_CapacidadCarga.getText()));
            }
        }
    }
    private void limpiarSeleccion() {
        tb_listaVehiculos.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }
    private void limpiarCamposVehiculo() {
        txf_matricula.clear();
        txf_marca.clear();
        txf_modelo.clear();
        txf_AñoFabricacion.clear();
        txf_NumPuertas.clear();
        txf_CapacidadCarga.clear();
        cmb_TipoVehiculo.getSelectionModel().clearSelection();
        chb_esautomatica.setValue("Manual");
    }
    public void setApp(App app) {
        this.app = app;
    }
}

