import java.util.ArrayList;
import java.util.List;

abstract class Figure {
    abstract double area();
    abstract Point centroid();
}

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Triangle extends Figure {
    Point A;
    Point B;
    Point C;

    Triangle(Point A, Point B, Point C) {
        if (!isValidTriangle(A, B, C)) {
            throw new IllegalArgumentException("Invalid triangle: vertices cannot be collinear.");
        }
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    double area() {
        return Math.abs((A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0);
    }

    @Override
    Point centroid() {
        double centroidX = (A.x + B.x + C.x) / 3.0;
        double centroidY = (A.y + B.y + C.y) / 3.0;
        return new Point(centroidX, centroidY);
    }

    @Override
    public String toString() {
        return String.format("Triangle[A(%.2f,%.2f) B(%.2f,%.2f) C(%.2f,%.2f)]", A.x, A.y, B.x, B.y, C.x, C.y);
    }

    private boolean isValidTriangle(Point A, Point B, Point C) {
        return (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) != 0;
    }
}

class Quadrilateral extends Figure {
    Point A;
    Point B;
    Point C;
    Point D;

    Quadrilateral(Point A, Point B, Point C, Point D) {
        if (!isValidQuadrilateral(A, B, C, D)) {
            throw new IllegalArgumentException("Invalid quadrilateral: vertices cannot form a degenerate quadrilateral.");
        }
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    @Override
    double area() {
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(A, B, C));
        triangles.add(new Triangle(A, C, D));
        double totalArea = 0.0;
        for (Triangle triangle : triangles) {
            totalArea += triangle.area();
        }
        return totalArea;
    }

    @Override
    Point centroid() {
        double centroidX = (A.x + B.x + C.x + D.x) / 4.0;
        double centroidY = (A.y + B.y + C.y + D.y) / 4.0;
        return new Point(centroidX, centroidY);
    }

    @Override
    public String toString() {
        return String.format("Quadrilateral[A(%.2f,%.2f) B(%.2f,%.2f) C(%.2f,%.2f) D(%.2f,%.2f)]",
                A.x, A.y, B.x, B.y, C.x, C.y, D.x, D.y);
    }

    private boolean isValidQuadrilateral(Point A, Point B, Point C, Point D) {
        return true;
    }
}

class Circle extends Figure {
    Point center;
    double radius;

    Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Invalid circle: radius must be positive.");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    Point centroid() {
        return center;
    }

    @Override
    public String toString() {
        return String.format("Circle[(%.2f,%.2f) Radius %.2f]", center.x, center.y, radius);
    }
}

public class figures {
    public static void main(String[] args) {
        Point A = new Point(0, 0);
        Point B = new Point(4, 0);
        Point C = new Point(0, 3);
        Point D = new Point(4, 3);
        Point center = new Point(2, 2);
        double radius = 2.5;

        Triangle triangle = new Triangle(A, B, C);
        Quadrilateral quadrilateral = new Quadrilateral(A, B, C, D);
        Circle circle = new Circle(center, radius);

        System.out.println("Triangle area: " + triangle.area());
        System.out.println("Triangle centroid: (" + triangle.centroid().x + ", " + triangle.centroid().y + ")");
        System.out.println(triangle.toString());

        System.out.println("Quadrilateral area: " + quadrilateral.area());
        System.out.println("Quadrilateral centroid: (" + quadrilateral.centroid().x + ", " + quadrilateral.centroid().y + ")");
        System.out.println(quadrilateral.toString());

        System.out.println("Circle area: " + circle.area());
        System.out.println("Circle centroid: (" + circle.centroid().x + ", " + circle.centroid().y + ")");
        System.out.println(circle.toString());
    }
}
