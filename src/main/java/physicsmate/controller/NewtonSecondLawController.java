package physicsmate.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import physicsmate.model.NewtonSecondLaw;

public class NewtonSecondLawController {

    @FXML private VBox inputBox;
    @FXML private Label resultLabel;
    @FXML private Label descriptionLabel;

    private int modeIndex = 0; // 0: F, 1: m, 2: a
    private TextField input1 = new TextField();
    private TextField input2 = new TextField();

    private final String[] descriptions = {
        "Menghitung Gaya (F) dari Massa (m) dan Percepatan (a)",
        "Menghitung Massa (m) dari Gaya (F) dan Percepatan (a)",
        "Menghitung Percepatan (a) dari Gaya (F) dan Massa (m)"
    };

    private final String[][] inputLabels = {
        {"Massa (kg)", "Percepatan (m/s²)"},
        {"Gaya (Newton)", "Percepatan (m/s²)"},
        {"Gaya (Newton)", "Massa (kg)"}
    };

    @FXML
    public void initialize() {
        setupForm();
    }

    private void setupForm() {
        inputBox.getChildren().clear();
        input1.clear();
        input2.clear();

        descriptionLabel.setText(descriptions[modeIndex]);

        Label label1 = new Label(inputLabels[modeIndex][0] + ":");
        Label label2 = new Label(inputLabels[modeIndex][1] + ":");

        inputBox.getChildren().addAll(label1, input1, label2, input2);
        resultLabel.setText("");
    }

    @FXML
    public void switchMode() {
        modeIndex = (modeIndex + 1) % 3;
        setupForm();
    }

    @FXML
    public void calculate() {
        try {
            double val1 = Double.parseDouble(input1.getText());
            double val2 = Double.parseDouble(input2.getText());
            double result = 0;
            String satuan = "";

            switch (modeIndex) {
                case 0 -> {
                    result = NewtonSecondLaw.calculateForce(val1, val2);
                    satuan = "Newton";
                }
                case 1 -> {
                    result = NewtonSecondLaw.calculateMass(val1, val2);
                    satuan = "kg";
                }
                case 2 -> {
                    result = NewtonSecondLaw.calculateAcceleration(val1, val2);
                    satuan = "m/s²";
                }
            }

            resultLabel.setText("Hasil: " + String.format("%.2f", result) + " " + satuan);

        } catch (NumberFormatException e) {
            resultLabel.setText("Input tidak valid.");
        }
    }
}
