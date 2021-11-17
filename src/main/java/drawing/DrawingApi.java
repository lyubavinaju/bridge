package drawing;

import drawing.context.Context;
import drawing.operation.Circle;
import drawing.operation.Line;

public interface DrawingApi {
    default void setDrawingAreaWidth(int width) {
        Context.getInstance().setDrawingAreaWidth(width);
    }

    default void setDrawingAreaHeight(int height) {
        Context.getInstance().setDrawingAreaHeight(height);
    }

    default int getDrawingAreaWidth() {
        Integer width = Context.getInstance().getDrawingAreaWidth();
        if (width == null) {
            throw new RuntimeException("Width is not set yet");
        }
        return width;
    }

    default int getDrawingAreaHeight() {
        Integer height = Context.getInstance().getDrawingAreaHeight();
        if (height == null) {
            throw new RuntimeException("Height is not set yet");
        }
        return height;
    }

    default void drawCircle(int x, int y, float w) {
        Context.getInstance().addShape(new Circle(x, y, w));
    }

    default void drawLine(int x1, int y1, int x2, int y2) {
        Context.getInstance().addShape(new Line(x1, y1, x2, y2));
    }

    void showResult();
}