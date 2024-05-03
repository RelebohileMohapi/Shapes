package com.example.shapes;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeView {
    private final List<Shape> shapes = new ArrayList<>();
    private final List<String> names = new ArrayList<>();
    private int currentIndex = 0;
    private final Pane pane;
    private final Label shapeNameLabel;

    public ShapeView(Pane pane) {
        this.pane = pane;
        shapeNameLabel = new Label();
        shapeNameLabel.setLayoutX(400);
        shapeNameLabel.setLayoutY(180);
        shapeNameLabel.setStyle("-fx-font-size: 19px; -fx-text-fill: #333;");

        shapeNameLabel.setStyle("-fx-font-weight: bold");
        shapeNameLabel.setStyle("-fx-translate-y: -90;");

        initializeShapes();
        displayShape(currentIndex);
        pane.getChildren().addAll(shapeNameLabel); // Add the label to the pane
    }

    private void initializeShapes() {
        Rectangle rectangle = new Rectangle(100, 100, Color.BLACK);
        rectangle.setX(350);
        rectangle.setY(250);

        Circle circle = new Circle(50, Color.BLUE);
        circle.setCenterX(400);
        circle.setCenterY(300);

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(450.0, 250.0, 400.0, 350.0, 500.0, 350.0);
        triangle.setFill(Color.BROWN);

        shapes.add(rectangle);
        names.add("Rectangle");
        shapes.add(circle);
        names.add("Circle");
        shapes.add(triangle);
        names.add("Triangle");

        for (Shape shape : shapes) {
            final double[] initialX = new double[1];
            final double[] initialY = new double[1];

            shape.setOnMousePressed(event -> {
                initialX[0] = event.getSceneX() - shape.getLayoutX();
                initialY[0] = event.getSceneY() - shape.getLayoutY();
            });

            shape.setOnMouseDragged(event -> {
                shape.setLayoutX(event.getSceneX() - initialX[0]);
                shape.setLayoutY(event.getSceneY() - initialY[0]);
            });
        }
    }

    public void nextShape() {
        if (currentIndex < shapes.size() - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        displayShape(currentIndex);
    }

    public void previousShape() {
        if (currentIndex > 0) {
            currentIndex--;
        } else {
            currentIndex = shapes.size() - 1;
        }
        displayShape(currentIndex);
    }

    private void displayShape(int index) {
        pane.getChildren().removeAll(shapes);
        pane.getChildren().add(shapes.get(index));
        shapeNameLabel.setText(names.get(index));  // Update the label to display the current shape's name
    }

    public void changeBackground() {
        Color newColor = Color.color(Math.random(), Math.random(), Math.random());
        pane.setBackground(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundFill(newColor, null, null)));
    }
}
