public class Point3D{
    private double xCoord, yCoord, zCoord;
    
    public double getX() { return xCoord; }
    public double getY() { return yCoord; }
    public double getZ() { return zCoord; }
    
    public void setX(double x){ xCoord = x;}
    
    public String toString() { return "("+xCoord+", "+yCoord+", "+zCoord+")";}
    
    public static void main(String[] args){
        Point3D pt3d = new Point3D();
        pt3d.setX( Math.sqrt(3));
        pt3d.yCoord = -12;
        pt3d.zCoord = 88;
        
        System.out.println(pt3d);
        
        int[] n = {1, 3, 5, 2, 4};
        System.out.println(n[2]);
    }
}