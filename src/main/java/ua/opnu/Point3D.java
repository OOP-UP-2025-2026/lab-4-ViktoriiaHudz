package ua.opnu;

public class Point3D extends Point {

    private int z;
    public Point3D() {

        this.z = 0;
    }
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public int getZ() {
        return this.z;
    }
    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    @Override
    public String toString() {

        return "(" + getX() + ", " + getY() + ", " + this.z + ")";
    }

    @Override
    public double distanceFromOrigin() {
        int x = getX();
        int y = getY();
        return Math.sqrt(x*x + y*y + this.z*this.z);
    }
    public double distance(Point3D p) {
        int dx = this.getX() - p.getX();
        int dy = this.getY() - p.getY();
        int dz = this.z - p.getZ();
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }
}
