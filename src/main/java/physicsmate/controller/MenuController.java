package physicsmate.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuController {

    @FXML private VBox menuBox;


    @FXML
    public void openKineticEnergy() throws IOException {
        openWindow("/physicsmate/kinetic_energy.fxml", "Energi Kinetik");
    }

    @FXML
    public void openNewtonSecondLaw() throws IOException {
        openWindow("/physicsmate/newton_second_law.fxml", "Hukum Newton II");
    }

    @FXML
    public void openWave() throws IOException {
        openWindow("/physicsmate/wave.fxml", "Gelombang");
    }

    private void openWindow(String fxmlPath, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
