package at.uastw.nrg_1.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EnergyApp extends Application {

    private Label currentEnergyLabel = new Label("Current Energy: ");
    private TextArea historicalDataArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button fetchCurrentButton = new Button("Fetch Current Energy");
        fetchCurrentButton.setOnAction(e -> fetchCurrentEnergy());

        TextField startField = new TextField();
        startField.setPromptText("Start Date (e.g. 2025-01-01)");

        TextField endField = new TextField();
        endField.setPromptText("End Date (e.g. 2025-01-10)");

        Button fetchHistoricalButton = new Button("Fetch Historical Data");
        fetchHistoricalButton.setOnAction(e -> fetchHistoricalData(startField.getText(), endField.getText()));

        VBox layout = new VBox(10, fetchCurrentButton, currentEnergyLabel, startField, endField, fetchHistoricalButton, historicalDataArea);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Energy Monitor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fetchCurrentEnergy() {
        String url = "http://localhost:8080/energy/current";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(response -> {
    Platform.runLater(() -> {
        currentEnergyLabel.setText("Current Energy: " + response);
    });
});

    }

    private void fetchHistoricalData(String start, String end) {
        String url = "http://localhost:8080/energy/historical?start=" + start + "&end=" + end;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(response -> {
                    Platform.runLater(() -> {
                        historicalDataArea.setText(response);
                    });
                });
                
    }
}
