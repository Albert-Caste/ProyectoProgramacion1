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

    private Parqueadero parqueaderoUQ =new Parqueadero("ParqueaderoUQ", "123");
    private Tarifa tarifaUQ = new Tarifa(3500,2000, 500, 25000, 15000,30000, 20000, 120000, 60000);


    private Administrador administrador;
    private Operador operador;




    public App(){
        parqueaderoUQ.setTheTarifa(tarifaUQ);
        administrador = new Administrador("Daniel","000", "Ocampo", "321456", "123"   );
        parqueaderoUQ.getListPersonas().add(administrador);
        operador = new Operador("Albert", "111", "Castellanos", "65321", "321");
        parqueaderoUQ.getListPersonas().add(operador);


    }

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




    //get y  sett de ParqueaderoUQ


    public Parqueadero getParqueaderoUQ() {
        return parqueaderoUQ;
    }

    public void setParqueaderoUQ(Parqueadero parqueaderoUQ) {
        parqueaderoUQ = parqueaderoUQ;
    }

    public Tarifa getTarifaUQ() {
        return tarifaUQ;
    }

    public void setTarifaUQ(Tarifa tarifaUQ) {
        this.tarifaUQ = tarifaUQ;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }
}