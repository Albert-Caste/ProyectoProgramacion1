module co.edu.uniquindio.parquederojfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.parquederojfx to javafx.fxml;
    opens co.edu.uniquindio.parquederojfx.viewController to javafx.fxml;
    exports co.edu.uniquindio.parquederojfx;
}