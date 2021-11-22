package drawing.impl;

import drawing.DrawingApi;
import drawing.context.DrawingContext;
import drawing.shape.Circle;
import drawing.shape.Line;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;

public class AwtDrawing extends Frame implements DrawingApi {

    private static final Color COLOR = Color.BLUE;

    private void draw(Graphics2D ga, Line line) {
        ga.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    private void draw(Graphics2D ga, Circle circle) {
        ga.fill(new Ellipse2D.Float(circle.getX(), circle.getY(), circle.getW(), circle.getW()));
    }

    @Override
    public void showResult() {
        this.setSize(getDrawingAreaWidth(), getDrawingAreaHeight());
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(COLOR);
        DrawingContext.getInstance().getShapes().forEach(shape -> {
            if (shape instanceof Line) {
                draw(ga, (Line) shape);
            } else {
                draw(ga, (Circle) shape);
            }
        });
    }
}
