package physicsmate.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import physicsmate.model.Gravity;

public class GravityController {

    @FXML private VBox inputBox;
    @FXML private Label resultLabel;
    @FXML private Label descriptionLabel;

    private int modeIndex = 0; // 0: F, 1: m1, 2: m2, 3: r
    private TextField input1 = new TextField();
    private TextField input2 = new TextField();
    private TextField input3 = new TextField();

    private final String[] descriptions = {
        "Menghitung Gaya Gravitasi (F) dari m₁, m₂, dan r",
        "Menghitung Massa 1 (m₁) dari F, m₂, dan r",
        "Menghitung Massa 2 (m₂) dari F, m₁, dan r",
        "Menghitung Jarak (r) dari F, m₁, dan m₂"
    };

    private final String[][] inputLabels = {
        {"Massa 1 (kg)", "Massa 2 (kg)", "Jarak (m)"},
        {"Gaya (N)", "Massa 2 (kg)", "Jarak (m)"},
        {"Gaya (N)", "Massa 1 (kg)", "Jarak (m)"},
        {"Gaya (N)", "Massa 1 (kg)", "Massa 2 (kg)"}
    };

    @FXML
    public void initialize() {
        setupForm();
    }

    private void setupForm() {
        inputBox.getChildren().clear();
        input1.clear();
        input2.clear();
        input3.clear();

        descriptionLabel.setText(descriptions[modeIndex]);

        Label label1 = new Label(inputLabels[modeIndex][0] + ":");
        Label label2 = new Label(inputLabels[modeIndex][1] + ":");
        Label label3 = new Label(inputLabels[modeIndex][2] + ":");

        inputBox.getChildren().addAll(label1, input1, label2, input2, label3, input3);
        resultLabel.setText("");
    }

    @FXML
    public void switchMode() {
        modeIndex = (modeIndex + 1) % 4;
        setupForm();
    }

    @FXML
    public void calculate() {
        try {
            double val1 = Double.parseDouble(input1.getText());
            double val2 = Double.parseDouble(input2.getText());
            double val3 = Double.parseDouble(input3.getText());
            double result = 0;
            String satuan = "";

            switch (modeIndex) {
                case 0 -> {
                    result = Gravity.calculateForce(val1, val2, val3);
                    satuan = "Newton";
                }
                case 1 -> {
                    result = Gravity.calculateMass1(val1, val2, val3);
                    satuan = "kg";
                }
                case 2 -> {
                    result = Gravity.calculateMass2(val1, val2, val3);
                    satuan = "kg";
                }
                case 3 -> {
                    result = Gravity.calculateDistance(val1, val2, val3);
                    satuan = "meter";
                }
            }

            resultLabel.setText("Hasil: " + String.format("%.5e", result) + " " + satuan);

        } catch (NumberFormatException e) {
            resultLabel.setText("Input tidak valid.");
        }
    }
}
