class Point {
    double x;
    double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Triangle {
    Point vertex1;
    Point vertex2;
    Point vertex3;
    
    public Triangle(Point vertex1, Point vertex2, Point vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        
        // Перевірка на існування трикутника та його не виродженість
        if (calculateArea() == 0) {
            throw new IllegalArgumentException("Трикутник є виродженим (вершини лежать на одній прямій).");
        }
    }
    
    private double calculateArea() {
        return 0.5 * Math.abs((vertex1.x - vertex3.x) * (vertex2.y - vertex3.y) - (vertex2.x - vertex3.x) * (vertex1.y - vertex3.y));
    }
    
    public double area() {
        return calculateArea();
    }
    
    public Point centroid() {
        double centroidX = (vertex1.x + vertex2.x + vertex3.x) / 3;
        double centroidY = (vertex1.y + vertex2.y + vertex3.y) / 3;
        return new Point(centroidX, centroidY);
    }
}

public class Trianglee {
    public static void main(String[] args) {
        Point vertex1 = new Point(0, 0);
        Point vertex2 = new Point(4, 0);
        Point vertex3 = new Point(2, 3);
        
        Triangle triangle = new Triangle(vertex1, vertex2, vertex3);
        
        System.out.println("Площа трикутника: " + triangle.area());
        System.out.println("Центроїд трикутника: " + triangle.centroid());
    }
}
