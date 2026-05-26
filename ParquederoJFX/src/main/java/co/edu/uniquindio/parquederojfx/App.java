package co.edu.uniquindio.parquederojfx;

import co.edu.uniquindio.parquederojfx.model.Administrador;
import co.edu.uniquindio.parquederojfx.model.Operador;
import co.edu.uniquindio.parquederojfx.model.Parqueadero;
import co.edu.uniquindio.parquederojfx.model.Tarifa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Parqueadero parqueaderoUQ =
            new Parqueadero("ParqueaderoUQ", "123");

    private static Tarifa tarifaUQ =
            new Tarifa(
                    3500,
                    2000,
                    500,
                    25000,
                    15000,
                    30000,
                    20000,
                    120000,
                    60000
            );

    static {

        parqueaderoUQ.setTheTarifa(tarifaUQ);

        Administrador administrador =
                new Administrador(
                        "Daniel",
                        "000",
                        "Ocampo",
                        "321456",
                        "123"
                );

        Operador operador =
                new Operador(
                        "Albert",
                        "111",
                        "Castellanos",
                        "65321",
                        "321"
                );

        parqueaderoUQ
                .getListPersonas()
                .add(administrador);

        parqueaderoUQ
                .getListPersonas()
                .add(operador);
    }

    public static Parqueadero getParqueadero(){

        return parqueaderoUQ;
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        App.class.getResource(
                                "administrador-view.fxml"
                        )
                );

        Scene scene =
                new Scene(loader.load());

        stage.setScene(scene);

        stage.setTitle("ParquederoUQ");

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}