package co.edu.uniquindio.parquederojfx.viewController;

import co.edu.uniquindio.parquederojfx.App;
import co.edu.uniquindio.parquederojfx.controller.EspacioController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EspaciosViewController {

    private EspacioController espaciosController;

    public EspaciosViewController(){

        espaciosController =
                new EspacioController();
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

            stage.setScene(scene);

            stage.setTitle(
                    "Parqueadero"
            );

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
