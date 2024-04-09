class Point {
    double x;
    double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "(" + x + ";" + y + ")";
    }
}

class Segment {
    Point start;
    Point end;
    
    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (start.x == end.x && start.y == end.y) {
            throw new IllegalArgumentException("Початок і кінець відрізка не можуть бути однією точкою.");
        }
    }
    
    public double length() {
        double dx = end.x - start.x;
        double dy = end.y - start.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public Point middle() {
        double mx = (start.x + end.x) / 2;
        double my = (start.y + end.y) / 2;
        return new Point(mx, my);
    }
    
    public Point intersection(Segment another) {
        double x1 = this.start.x;
        double y1 = this.start.y;
        double x2 = this.end.x;
        double y2 = this.end.y;
        
        double x3 = another.start.x;
        double y3 = another.start.y;
        double x4 = another.end.x;
        double y4 = another.end.y;
        
        double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (d == 0) {
            return null;
        }
        
        double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
        double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;
        
        if (xi < Math.min(x1, x2) || xi > Math.max(x1, x2) || xi < Math.min(x3, x4) || xi > Math.max(x3, x4)) {
            return null;
        }
        
        return new Point(xi, yi);
    }
}

public class Segmentt {
    public static void main(String[] args) {
        Point startPoint = new Point(1, 1);
        Point endPoint = new Point(4, 5);
        Segment segment1 = new Segment(startPoint, endPoint);
        
        System.out.println("Довжина відрізка: " + segment1.length());
        System.out.println("Середня точка відрізка: " + segment1.middle());
        
        Point startAnother = new Point(2, 4);
        Point endAnother = new Point(5, 2);
        Segment segment2 = new Segment(startAnother, endAnother);
        
        Point intersectionPoint = segment1.intersection(segment2);
        if (intersectionPoint != null) {
            System.out.println("Точка перетину: " + intersectionPoint.x + ", " + intersectionPoint.y);
        } else {
            System.out.println("Відрізки не перетинаються.");
        }
    }
}
