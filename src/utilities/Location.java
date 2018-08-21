package utilities;

public class Location {
    private float x;
    private float y;
    private float z;
    private float facing_xy;
    private float facing_xz;

    public Location(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.facing_xy = 0;
        this.facing_xz = 0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getFacing_xy(){
        return facing_xy;
    }

    public float getFacing_xz(){
        return facing_xz;
    }

    public void updateFacing_xy(float increment){
        this.facing_xy+=increment;
    }

    public void updateFacing_xz(float increment){
        this.facing_xz+=increment;
    }

    public void setLocation(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setFacing_xy(float facing_xy){
        this.facing_xy = facing_xy;
    }

    public void setFacing_xz(float facing_xz){
        this.facing_xz = facing_xz;
    }

    public float getEuclideanDistance(Location l){
        float dist = (float) Math.sqrt(Math.pow((this.x - l.getX()),2) + Math.pow((this.y - l.getY()),2) +
                Math.pow((this.z - l.getZ()),2));

        return dist;
    }
}
