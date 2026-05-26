package co.edu.uniquindio.parquederojfx.viewController;



import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.controller.ParqueaderoController;
import co.edu.uniquindio.parquederojfx.model.Servicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;

public class ParqueaderoViewController {



    private ParqueaderoController parqueaderoController;

    private ObservableList<Servicio> listaServicios =
            FXCollections.observableArrayList();

    public ParqueaderoViewController(){

        parqueaderoController =
                new ParqueaderoController();
    }

    @FXML
    private Button btnIniciarServicio;

    @FXML
    private Button btGestionCliente;

    @FXML
    private Button btGestionVehiculo;

    @FXML
    private Button btGestionEspacios;

    @FXML
    private Button btGestionMensualidad;

    @FXML
    private TextField txtIdCliente;

    @FXML
    private TextField txtPlacaVehiculo;

    @FXML
    private TableView<Servicio> tablaServicio;

    @FXML
    private TableColumn<Servicio,String> tablaColumnaCliente;

    @FXML
    private TableColumn<Servicio,String> tablaColumnaPlaca;

    @FXML
    private TableColumn<Servicio,String> tablaColumnaHoraInicio;

    @FXML
    private TableColumn<Servicio,String> tablaColumnaHoraFinal;

    @FXML
    private TableColumn<Servicio,Double> tablaColumnaPagoTotal;

    @FXML
    public void initialize(){

        inicializarTabla();
    }

    public void inicializarTabla(){

        tablaColumnaCliente.setCellValueFactory(
                new PropertyValueFactory<>("cliente")
        );

        tablaColumnaPlaca.setCellValueFactory(
                new PropertyValueFactory<>("vehiculo")
        );

        tablaColumnaHoraInicio.setCellValueFactory(
                new PropertyValueFactory<>("horaInicio")
        );

        tablaColumnaHoraFinal.setCellValueFactory(
                new PropertyValueFactory<>("horaFinal")
        );

        tablaColumnaPagoTotal.setCellValueFactory(
                new PropertyValueFactory<>("precioServicio")
        );

        tablaServicio.setItems(listaServicios);
    }

    @FXML
    public void onIniciarServicio(){

        String idCliente =
                txtIdCliente.getText();

        String placa =
                txtPlacaVehiculo.getText();

        parqueaderoController
                .iniciarServicio(
                        idCliente,
                        placa
                );

        actualizarTabla();
    }

    public void actualizarTabla(){

        listaServicios.clear();

        listaServicios.addAll(
                parqueaderoController
                        .obtenerServicios()
        );
    }

    @FXML
    public void onGestionCliente(){

        abrirVentana(
                "cliente-view.fxml",
                "Gestión Cliente"
        );
    }

    @FXML
    public void onGestionVehiculo(){

        abrirVentana(
                "vehiculo-view.fxml",
                "Gestión Vehículo"
        );
    }

    @FXML
    public void onGestionEspacios(){

        abrirVentana(
                "espacios-view.fxml",
                "Gestión Espacios"
        );
    }

    @FXML
    public void onGestionMensualidad(){

        abrirVentana(
                "mensualidad-view.fxml",
                "Mensualidad"
        );
    }

    public void abrirVentana(String nombreFXML,
                             String titulo){

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            App.class.getResource(
                                    nombreFXML
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            Stage stage =
                    new Stage();

            stage.setTitle(titulo);

            stage.setScene(scene);

            stage.show();

            Stage actual =
                    (Stage) btnIniciarServicio
                            .getScene()
                            .getWindow();

            actual.close();

        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void onTerminarServicio() {
        System.out.println("TerminarServicio");
    }

    public void onCalcularCosto() {
        System.out.println("CalcularServicio");
    }

    public void onEliminarServicio() {
        System.out.println("EliminarServicio");
    }
}
