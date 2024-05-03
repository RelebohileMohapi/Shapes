package com.example.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private ShapeView shapeView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        shapeView = new ShapeView(root);


        Button btnPrevious = new Button("Previous");
        btnPrevious.setLayoutX(50);
        btnPrevious.setLayoutY(550);
        btnPrevious.setOnAction(e -> shapeView.previousShape());

        Button btnNext = new Button("Next");
        btnNext.setLayoutX(150);
        btnNext.setLayoutY(550);
        btnNext.setOnAction(e -> shapeView.nextShape());

        Button btnChangeBackground = new Button("Change Background");
        btnChangeBackground.setLayoutX(250);
        btnChangeBackground.setLayoutY(550);
        btnChangeBackground.setOnAction(e -> shapeView.changeBackground());





        root.getChildren().addAll(btnPrevious, btnNext, btnChangeBackground);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setTitle("Shape Slider Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
