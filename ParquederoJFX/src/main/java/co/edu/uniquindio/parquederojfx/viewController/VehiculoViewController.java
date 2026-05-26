package co.edu.uniquindio.parquederojfx.viewController;

import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.controller.VehiculoController;
import co.edu.uniquindio.parquederojfx.model.Carro;
import co.edu.uniquindio.parquederojfx.model.TipoCarro;
import co.edu.uniquindio.parquederojfx.model.Vehiculo;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.stage.Stage;

public class VehiculoViewController {

    VehiculoController vehiculoController;

    ObservableList<Carro> listVehiculos =
            FXCollections.observableArrayList();

    Carro selectedVehiculo;

    @FXML
    private Button btRegresar;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtColor;

    @FXML
    private ComboBox<TipoCarro> cbTipoCarro;

    @FXML
    private TableView<Carro> tblListVehiculos;

    @FXML
    private TableColumn<Carro,String> tbcPlaca;

    @FXML
    private TableColumn<Carro,String> tbcColor;

    @FXML
    private TableColumn<Carro,String> tbcTipoCarro;

    @FXML
    void initialize(){

        vehiculoController =
                new VehiculoController();

        cargarTiposCarro();

        initView();
    }

    private void cargarTiposCarro(){

        cbTipoCarro.getItems()
                .addAll(
                        TipoCarro.values()
                );
    }

    private void initView(){

        initDataBinding();

        obtenerVehiculos();

        tblListVehiculos
                .setItems(listVehiculos);

        listenerSelection();
    }

    private void initDataBinding(){

        tbcPlaca.setCellValueFactory(
                cellData ->
                        new SimpleStringProperty(
                                cellData.getValue()
                                        .getPlaca()
                        )
        );

        tbcColor.setCellValueFactory(
                cellData ->
                        new SimpleStringProperty(
                                cellData.getValue()
                                        .getColor()
                        )
        );

        tbcTipoCarro.setCellValueFactory(
                cellData ->
                        new SimpleStringProperty(
                                cellData.getValue()
                                        .getTipoCarro()
                                        .toString()
                        )
        );
    }

    private void obtenerVehiculos(){

        for(Vehiculo vehiculo :
                vehiculoController
                        .obtenerVehiculos()){

            if(vehiculo instanceof Carro){

                listVehiculos.add(
                        (Carro) vehiculo
                );
            }
        }
    }

    private Carro buildVehiculo(){

        return new Carro(
                txtPlaca.getText(),
                txtColor.getText(),
                cbTipoCarro.getValue()
        );
    }

    @FXML
    void onAgregarVehiculo(){

        Carro carro =
                buildVehiculo();

        if(vehiculoController
                .crearVehiculo(carro)){

            listVehiculos.add(carro);

            limpiarCampos();
        }
    }

    @FXML
    void onEliminar(){

        if(selectedVehiculo != null){

            vehiculoController
                    .eliminarVehiculo(
                            selectedVehiculo
                                    .getPlaca()
                    );

            listVehiculos
                    .remove(selectedVehiculo);

            limpiarCampos();
        }
    }

    @FXML
    void onLimpiar(){

        limpiarCampos();
    }

    @FXML
    void onActualizarVehiculo(){

        if(selectedVehiculo != null){

            selectedVehiculo.setPlaca(
                    txtPlaca.getText()
            );

            selectedVehiculo.setColor(
                    txtColor.getText()
            );

            selectedVehiculo.setTipoCarro(
                    cbTipoCarro.getValue()
            );

            tblListVehiculos.refresh();

            limpiarCampos();
        }
    }

    private void listenerSelection(){

        tblListVehiculos
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs,
                         oldSelection,
                         newSelection) -> {

                            selectedVehiculo =
                                    newSelection;

                            mostrarInformacionVehiculo(
                                    selectedVehiculo
                            );
                        }
                );
    }

    private void mostrarInformacionVehiculo(
            Carro carro
    ){

        if(carro != null){

            txtPlaca.setText(
                    carro.getPlaca()
            );

            txtColor.setText(
                    carro.getColor()
            );

            cbTipoCarro.setValue(
                    carro.getTipoCarro()
            );
        }
    }

    private void limpiarCampos(){

        txtPlaca.clear();

        txtColor.clear();

        cbTipoCarro.setValue(null);
    }

    @FXML
    public void onRegresar(){

        abrirParqueadero();
    }

    public void abrirParqueadero(){

        try{

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
}