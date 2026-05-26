package co.edu.uniquindio.parquederojfx.viewController;

import co.edu.uniquindio.parquederojfx.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

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
}
