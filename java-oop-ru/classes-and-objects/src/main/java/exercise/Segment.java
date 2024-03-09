package exercise;

// BEGIN
public class Segment {
    private Point BeginPoint;
    private Point EndPoint;

    public Point getBeginPoint() {
        return BeginPoint;
    }

    public Point getEndPoint() {
        return EndPoint;
    }

    public Point getMidPoint() {
        int x = BeginPoint.getX() + EndPoint.getX();
        int y = BeginPoint.getY() + EndPoint.getY();
        return new Point(x, y);
    }

    public Segment(Point beginPoint, Point endPoint) {
        BeginPoint = beginPoint;
        EndPoint = endPoint;
    }
}
// END
