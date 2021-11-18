package drawing.impl;

import drawing.DrawingApi;
import drawing.context.DrawingContext;
import drawing.operation.Circle;
import drawing.operation.Line;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFxDrawing extends Application implements DrawingApi {
    private static final Color COLOR = Color.BLUE;

    private void draw(GraphicsContext gc, Line line) {
        gc.strokeLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    private void draw(GraphicsContext gc, Circle circle) {
        gc.fillOval(circle.getX(), circle.getY(), circle.getW(), circle.getW());
    }

    @Override
    public void showResult() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Canvas canvas = new Canvas(getDrawingAreaWidth(), getDrawingAreaHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(COLOR);
        DrawingContext.getInstance().getShapes().forEach(shape -> {
            if (shape instanceof Line) {
                draw(gc, (Line) shape);
            } else {
                draw(gc, (Circle) shape);
            }
        });
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
