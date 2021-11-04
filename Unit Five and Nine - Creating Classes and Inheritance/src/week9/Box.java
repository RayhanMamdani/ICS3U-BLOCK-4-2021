package week9;

public class Box extends Rectangle {
    private int height;

    public Box(int rectSide) {
        super(rectSide);
        height = rectSide;
    }

    public Box(int rectLength, int rectWidth, int boxHeight) {
        super(rectLength, rectWidth);
        height = boxHeight;
    }

    public int getArea() {
        return (2 * super.getArea()) + (2 * (super.getLength() * height)) + (2 * (super.getWidth() * height));

    }

    public int getPerimeter() {
        return (2 * super.getPerimeter()) + (4 * height);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (obj instanceof Box) {
                return height == ((Box) obj).height;
            }
        }
        return false;
    }
}
