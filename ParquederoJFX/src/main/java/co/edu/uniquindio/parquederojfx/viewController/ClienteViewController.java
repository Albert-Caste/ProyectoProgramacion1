package co.edu.uniquindio.parquederojfx.viewController;


import javafx.scene.control.ComboBox;
import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.controller.ClienteController;
import co.edu.uniquindio.parquederojfx.model.Cliente;
import co.edu.uniquindio.parquederojfx.model.Persona;
import co.edu.uniquindio.parquederojfx.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClienteViewController {

    @FXML
    private Button btRegresar;

    @FXML
    public void onRegresar(){

        abrirParqueadero();

    }



    public void abrirParqueadero(){

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource(
                                    "parquedero-view.fxml"
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            Stage stage =
                    new Stage();

            stage.setScene(scene);

            stage.show();

            Stage actual =
                    (Stage) btRegresar
                            .getScene()
                            .getWindow();

            actual.close();

        }catch (Exception e){

            e.printStackTrace();
        }
    }

    ClienteController clienteController;
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;


    @FXML
    private ComboBox<Usuario> cbTipoUsuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Cliente> tblListCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private TableColumn<Cliente, String> tbcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Cliente, String> tbcApellido;

    @FXML
    private Button btbAgregarCliente;

    @FXML
    private TableColumn<Cliente, String> tbcCedula;

    @FXML
    private TextField txtCedula;
    private App app;

    @FXML
    void onAgregarCliente() {
        agregarCliente();
    }

    @FXML
    void onActualizarCliente() {
        actualizarCliente();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarCliente();
    }

    @FXML
    void initialize() {
        this.app=app;
        clienteController = new ClienteController();
        initView();
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerClientes();

        // Limpiar la tabla
        tblListCliente.getItems().clear();

        // Agregar los elementos a la tabla
        tblListCliente.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }


        private void obtenerClientes() {

            for(Persona persona : clienteController.obtenerListaClientes()){

                if(persona instanceof Cliente){

                    listClientes.add((Cliente) persona);
                }
            }
        }

    private void listenerSelection() {
        tblListCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtCedula.setText(cliente.getDocumento());
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
        }
    }

    private void agregarCliente() {
        Cliente cliente = buildCliente();
        if (clienteController.crearClienteSinAtributos(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }

    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txtNombre.getText(), txtCedula.getText(), txtApellido.getText(),txtNombre.getText(), Usuario.ESTUDIANTE);
        return cliente;
    }

    private void eliminarCliente() {
        if (clienteController.eliminarCliente(txtCedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }

    private void actualizarCliente() {

        if (selectedCliente != null &&
                clienteController.actualizarCliente(selectedCliente.getDocumento(), buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listClientes.set(index, buildCliente());
            }

            tblListCliente.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }

    private void limpiarSeleccion() {
        tblListCliente.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
