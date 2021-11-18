package drawing.context;

import drawing.operation.Shape;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DrawingContext {
    private static DrawingContext instance;
    @Getter
    private final List<Shape> shapes = new ArrayList<>();
    @Getter
    @Setter
    private Integer drawingAreaWidth;
    @Getter
    @Setter
    private Integer drawingAreaHeight;

    public static DrawingContext getInstance() {
        if (instance == null) {
            instance = new DrawingContext();
        }
        return instance;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }
}
