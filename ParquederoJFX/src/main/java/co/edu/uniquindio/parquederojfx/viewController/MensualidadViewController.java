package co.edu.uniquindio.parquederojfx.viewController;

import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.controller.MensualidadController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class MensualidadViewController {

    private MensualidadController mensualidadController;

    public MensualidadViewController(){

        mensualidadController =
                new MensualidadController();
    }

    @FXML
    private Button btRegresar;

    @FXML
    public void onRegresar(){

        regresarParqueadero();
    }

    public void regresarParqueadero(){

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

            stage.setTitle(
                    "Parqueadero"
            );

            stage.setScene(scene);

            stage.show();

            // cerrar ventana actual

            Stage ventanaActual =
                    (Stage) btRegresar
                            .getScene()
                            .getWindow();

            ventanaActual.close();

        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
