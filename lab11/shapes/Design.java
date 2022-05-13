package shapes;

interface Shape {
    void getArea();
}

interface ShapeFactory {
    Shape getShape();
}

class Circle implements Shape {
    public void getArea() {
        System.out.println("Circle area!");
    }
}

class Square implements Shape {
    public void getArea() {
        System.out.println("Square area!");
    }
}

class Rectangle implements Shape {
    public void getArea() {
        System.out.println("Rectangle area!");
    }
}

class CircleFactory implements ShapeFactory {
    public Shape getShape() {
        return new Circle();
    }
}

class SquareFactory implements ShapeFactory {
    public Shape getShape() {
        return new Square();
    }
}

class RectangleFactory implements ShapeFactory {
    public Shape getShape() {
        return new Rectangle();
    }
}

public class Design {
    public static void addShape(ShapeFactory fact) {
        Shape s = fact.getShape();
        s.getArea();
    }

    public static void main(String[] args) {
        addShape(new CircleFactory());

        addShape(new SquareFactory());

        addShape(new RectangleFactory());
    }

}