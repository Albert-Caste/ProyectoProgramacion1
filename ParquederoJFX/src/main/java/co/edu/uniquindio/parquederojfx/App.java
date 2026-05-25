package co.edu.uniquindio.parquederojfx;

import co.edu.uniquindio.parquederojfx.model.Parqueadero;
import co.edu.uniquindio.parquederojfx.model.Tarifa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                App.class.getResource(
                        "administrador-view.fxml"
                )
        );

        Scene scene = new Scene(loader.load());

        stage.setScene(scene);

        stage.setTitle("ParquederoUQ");

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}