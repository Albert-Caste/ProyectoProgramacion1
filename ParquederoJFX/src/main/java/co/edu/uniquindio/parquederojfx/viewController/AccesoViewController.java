package co.edu.uniquindio.parquederojfx.viewController;

import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.controller.AccesoController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccesoViewController {

    AccesoController administradorController;

    public AccesoViewController() {

        administradorController =
                new AccesoController();
    }

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombreTrabajador;

    @FXML
    private TextField txtIDTrabajador;

    @FXML
    private Button btValidarAcceso;

    @FXML
    public void onValidarAcceso() {

        String nombre =
                txtNombreTrabajador.getText();

        String documento =
                txtCedula.getText();


        String codigo =
                txtIDTrabajador.getText();

        boolean acceso =
                administradorController.validarAcceso(nombre, documento, codigo);

        if(acceso){

            abrirParquedero();

        }else{

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Datos incorrectos"
            );

            alert.showAndWait();
        }
    }

    private void abrirParquedero(){

        try {

            FXMLLoader loader = new FXMLLoader(
                    App.class.getResource(
                            "parquedero-view.fxml"
                    )
            );

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setTitle("Parquedero");
            stage.show();

            Stage actual =
                    (Stage) btValidarAcceso
                            .getScene()
                            .getWindow();

            actual.close();

        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
