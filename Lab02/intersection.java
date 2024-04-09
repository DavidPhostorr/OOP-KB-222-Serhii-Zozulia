class Point {
    double x;
    double y;


    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ":" + y + ")";
    }
}

class Line{
    double k;
    double b;

    public Line(double k, double b){
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
            if (Math.abs(this.k - other.k) < 1e-10 && Math.abs(this.b - other.b) < 1e-10) {
            return null;
        } else if (Math.abs(this.k - other.k) < 1e-10) {
            return null;
        } else {
            double x = (other.b - this.b) / (this.k - other.k);
            double y = this.k * x + this.b;
            return new Point(x, y);
        }
    }
}

public class intersection {
    public static void main(String[] args) {
        Line line1 = new Line(1, 1);
        Line line2 = new Line(-1, 3);
        
        Point intersectionPoint = line1.intersection(line2);
        if (intersectionPoint != null) {
            System.out.println("Точка перетину: " + intersectionPoint);
        } else {
            System.out.println("Лінії збігаються або паралельні.");
        }
    }
}
