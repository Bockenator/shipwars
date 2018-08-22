package ship.ammunition;
import utilities.Location;

//TODO: UPDATE THIS TO BE PROPER
public class Missile {
    private float damage;
    private float range;
    private float explosion_range;
    private float mass;
    private Location target_location;
    private float facing_xy;
    private float facing_xz;
    private float acceleration = 0;

    public Missile(float damage, float range, float explosion_range, float mass, Location target_location, float facing_xy, float facing_xz) {
        this.damage = damage;
        this.range = range;
        this.explosion_range = explosion_range;
        this.mass = mass;
        this.target_location = target_location;
        this.facing_xy = facing_xy;
        this.facing_xz = facing_xz;
    }

    //TODO: COMPLETE
    public void fire(){

    }

    public void lockTarget(Location target_location){
        this.target_location = target_location;
    }

    //TODO: COMPLETE
    public void trackTarget(){

    }

    //TODO: UPDATE TO VECTOR FORMAT
    public void turn_xy(float increment){
        facing_xy+=increment;
    }

    //TODO: UPDATE TO VECTOR FORMAT
    public void turn_xz(float increment){
        facing_xz+=increment;
    }

}
