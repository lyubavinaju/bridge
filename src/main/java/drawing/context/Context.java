package drawing.context;

import drawing.operation.Shape;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Context {
    private static Context instance;
    @Getter
    private final List<Shape> shapes = new ArrayList<>();
    @Getter
    @Setter
    private Integer drawingAreaWidth;
    @Getter
    @Setter
    private Integer drawingAreaHeight;

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }
}
