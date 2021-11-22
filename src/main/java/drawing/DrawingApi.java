package drawing;

import drawing.context.DrawingContext;
import drawing.shape.Circle;
import drawing.shape.Line;

public interface DrawingApi {
    default void setDrawingAreaWidth(int width) {
        DrawingContext.getInstance().setDrawingAreaWidth(width);
    }

    default void setDrawingAreaHeight(int height) {
        DrawingContext.getInstance().setDrawingAreaHeight(height);
    }

    default int getDrawingAreaWidth() {
        Integer width = DrawingContext.getInstance().getDrawingAreaWidth();
        if (width == null) {
            throw new RuntimeException("Width is not set yet");
        }
        return width;
    }

    default int getDrawingAreaHeight() {
        Integer height = DrawingContext.getInstance().getDrawingAreaHeight();
        if (height == null) {
            throw new RuntimeException("Height is not set yet");
        }
        return height;
    }

    default void drawCircle(int x, int y, float w) {
        DrawingContext.getInstance().addShape(new Circle(x, y, w));
    }

    default void drawLine(int x1, int y1, int x2, int y2) {
        DrawingContext.getInstance().addShape(new Line(x1, y1, x2, y2));
    }

    void showResult();
}