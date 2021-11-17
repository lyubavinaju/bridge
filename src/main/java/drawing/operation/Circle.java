package drawing.operation;

import lombok.Getter;

@Getter
public class Circle implements Shape {
    private final int x;
    private final int y;
    private final float w;

    public Circle(int x, int y, float w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}
