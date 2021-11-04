package week9;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int rectLength, int rectWidth) {
        length = rectLength;
        width = rectWidth;
    }

    public Rectangle(int rectSide) {
        length = rectSide;
        width = rectSide;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return (2 * width) + (2 * length);
    }

    public boolean isSquare() {
        return length == width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String toString() {
        return "Rectangle with length of " + length + " and width of " + width + ".";
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Rectangle) {
            Rectangle r = (Rectangle) obj;
            return length == r.length && width == r.width;
        }
        return false;
    }
}
