package physicsmate.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import physicsmate.model.Wave;

public class WaveController {

    @FXML private VBox inputBox;
    @FXML private Label resultLabel;
    @FXML private Label descriptionLabel;

    private int modeIndex = 0; // 0: v, 1: f, 2: lambda
    private TextField input1 = new TextField();
    private TextField input2 = new TextField();

    private final String[] descriptions = {
        "Menghitung Kecepatan Gelombang (v) dari Frekuensi (f) dan Panjang Gelombang (λ)",
        "Menghitung Frekuensi (f) dari Kecepatan Gelombang (v) dan Panjang Gelombang (λ)",
        "Menghitung Panjang Gelombang (λ) dari Kecepatan Gelombang (v) dan Frekuensi (f)"
    };

    private final String[][] inputLabels = {
        {"Frekuensi (Hz)", "Panjang Gelombang (m)"},
        {"Kecepatan Gelombang (m/s)", "Panjang Gelombang (m)"},
        {"Kecepatan Gelombang (m/s)", "Frekuensi (Hz)"}
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
                    result = Wave.calculateVelocity(val1, val2);
                    satuan = "m/s";
                }
                case 1 -> {
                    result = Wave.calculateFrequency(val1, val2);
                    satuan = "Hz";
                }
                case 2 -> {
                    result = Wave.calculateWavelength(val1, val2);
                    satuan = "m";
                }
            }

            resultLabel.setText("Hasil: " + String.format("%.2f", result) + " " + satuan);

        } catch (NumberFormatException e) {
            resultLabel.setText("Input tidak valid.");
        }
    }
}
