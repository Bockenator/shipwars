package utilities;

import javax.vecmath.Vector3f;
//TODO: RENAME THIS CLASS - LOCATIONS HAVING A DIRECTION VECTOR IS WEIRD
// locations are used to mark a the point an object is at in the arena
public class Location {

    // locations have x,y,z coordinates as well as a direction vector to determine facing
    private float x;
    private float y;
    private float z;
    private Vector3f direction_vector;

    // constructor without direction vector
    public Location(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // constructor with direction vector (preferred)
    public Location(float x, float y, float z, Vector3f direction_vector) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction_vector = direction_vector;
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

    public Vector3f getDirection_vector() {
        return this.direction_vector;
    }

    public void setDirection_vector(Vector3f direction_vector){
        this.direction_vector = direction_vector;
    }

    public void setLocation(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //TODO: UPDATE THESE FOR VECTOR3F
//    public void updateFacing_xy(float increment){
//        this.facing_xy+=increment;
//    }
//
//    public void updateFacing_xz(float increment){
//        this.facing_xz+=increment;
//    }

    // gets the Euclidean distance between two location points
    public float getEuclideanDistance(Location l){
        float dist = (float) Math.sqrt(Math.pow((this.x - l.getX()),2) + Math.pow((this.y - l.getY()),2) +
                Math.pow((this.z - l.getZ()),2));

        return dist;
    }

    //TODO: FINISH PROPER LINE INTERSECTION CHECKING (MAYBE DISTINGUISH BETWEEN POTENTIAL COLLISION AND INTERSECTION)
    //checks if there is a point of intersection between two location object vectors
    public boolean willCollideWith(Vector3f v){
        return false;
    }
}
