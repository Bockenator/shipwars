package ship;
import ship.hardpoint.Hardpoint;
import ship.hardpoint.weapon.Weapon;
import ship.hardpoint.weapon.laser.Laser;
import ship.hardpoint.weapon.massdriver.MassDriver;
import ship.hardpoint.weapon.weaponprojectile.Beam;
import ship.hardpoint.weapon.weaponprojectile.Projectile;
import ship.hardpoint.weapon.weaponprojectile.WeaponProjectile;
import ship.section.*;
import utilities.Contact;
import utilities.Location;
import utilities.TargetClassification;

import java.util.ArrayList;
import java.util.Collections;

// ships are the objects which will fight in arenas, they are controlled by agents and can shoot and move
public class Ship {
    // ship parameters
    String name;
    Location location;
    Section [] sections;
    ArrayList<Weapon> weapons;
    EngineSection engine;
    ShipSize ship_size;
    boolean has_engine = false;
    private float mass;
    private float acceleration = 0;
    // contact data
    int contact_tracker = 1;
    ArrayList<Contact> contacts;
    ArrayList<Contact> nearby_enemies;
    ArrayList<Contact> on_collision_course;
    Contact target;
    // weapon range data
    private float max_weapon_range;
    private float optimal_weapon_range;

    // constructor
    public Ship(Section [] sections, String name) {
        this.sections = sections;
        this.name = name;
        init();
    }

    // init to check ship has an engine and to calculate other parameters
    public void init(){
        if (!(checkForEngine(this.sections))) {
            System.out.println("WARNING: No Engine on ship "+this.toString());
        }
        calcWeight();
        calcWeaponRanges();
        findWeapons();
        this.location = new Location(0,0,0);
    }

    //TODO: UPDATE
    public void accelerate(float force){
        if(has_engine){
            engine.increaseForce(mass, force);
        }
    }

    //TODO: UPDATE
    public void decelerate(float force){
        if(has_engine){
            engine.decreaseForce(mass, force);
        }
    }


    //TODO: UPDATE
//    public void turnXY(float increment){
//        location.updateFacing_xy(increment);
//    }

    //TODO: UPDATE
//    public void turnXZ(float increment){
//        location.updateFacing_xy(increment);
//    }

    public void setShip_size(ShipSize ship_size){
        this.ship_size = ship_size;
    }

    // check that the ship has an engine and set the engine
    private boolean checkForEngine(Section [] sections){
        for(Section s : sections){
            if (s instanceof EngineSection){
                this.engine = (EngineSection) s;
                this.has_engine = true;
                return true;
            }
        }
        return false;
    }

    // calculate the total TODO: MASS
    private void calcWeight(){
        float cum_weight = 0;
        for(Section s : sections){
            cum_weight+=s.getMass();
        }
        this.mass = cum_weight;
    }

    // calculate weapon ranges based on the data of all weapons
    private void calcWeaponRanges(){

        ArrayList<Float> ranges = new ArrayList<>();

        // loop over every hardpoint section and get the weapon range values
        for (Section s : this.sections){

            if (s instanceof HardpointSection){
                for (float r : ((HardpointSection) s).getMaxWeaponRange()){
                    ranges.add(r);
                }

            }
        }

        // set max and min based on the values of all weapon ranges
        this.max_weapon_range = Collections.max(ranges);

        //TODO: FIND A BETTER WAY TO REPRESENT OPTIMUM STRIKE DISTANCE
        // find average range and treat that as optimal weapon range
        float sum_ranges = 0;
        for (float f : ranges){
            sum_ranges+=f;
        }
        this.optimal_weapon_range = sum_ranges/((float) ranges.size());

    }

    // loop over every hardpoint section to get every weapon
    private void findWeapons(){

        for (Section s : this.sections){

            if (s instanceof HardpointSection){

                if (!(((HardpointSection) s).getWeapons().isEmpty())){

                    for (Weapon w : ((HardpointSection) s).getWeapons()){
                        this.weapons.add(w);
                    }
                }
            }
        }
    }

    // update and track radar contacts or delete/create ones as necessary
    public void simpleTrackContacts(Location [] new_contact_locations){

        // clear contact sub-lists
        this.on_collision_course.clear();
        this.nearby_enemies.clear();

        // assume all current contacts are invalid
        for (Contact c : this.contacts){
            c.setRecently_updated(false);
        }

        // update contacts and create a new one if needed
        boolean new_contact = true;
        for (Location l : new_contact_locations){
            new_contact = true;
            for (Contact c : this.contacts){
                //if a location is within 5km of a previous contact  location then assume it is the same contact
                if (c.getLocation().getEuclideanDistance(l) <= 5){
                    c.setLocation(l);
                    c.setRecently_updated(true);
                    new_contact = false;
                    break;
                }
            }
            // if the location is not within the threshold of previous locations then create a new contact for it
            if (new_contact){
                Contact new_c = new Contact(l, this.contact_tracker);
                this.contact_tracker++;
            }
        }

        for (Contact c : this.contacts){
            if (!(c.getRecently_updated())){
                this.contacts.remove(c);
            }
        }

        // repopulate contact sub-lists
        findNearbyEnemies();
        findContactsOnCollisionCourse();

    }

    // check for any contacts within 4000km that are enemies
    private void findNearbyEnemies(){
        for (Contact c : this.contacts){
            float dist = this.location.getEuclideanDistance(c.getLocation());
            if((dist <= 4000) && (c.getClassification() == TargetClassification.ENEMY)){
                this.nearby_enemies.add(c);

            }
        }
    }

    // check for any contacts on a collision course
    private void findContactsOnCollisionCourse(){
        for (Contact c : this.contacts){
            if(this.location.willCollideWith(c.getLocation().getDirection_vector())){
                this.on_collision_course.add(c);
            }
        }
    }

    // loop through all weapons and fire all weapons that are ready and return the projectiles created by it
    public ArrayList<WeaponProjectile> fireAllWeapons(){
        ArrayList<WeaponProjectile> fired = new ArrayList<>();

        for (Weapon w : this.weapons){

            if (w.readyToFire()){
                w.fire();
                if (w instanceof MassDriver) {
                    fired.add(new Projectile(this.location, w.getDamage(), ((MassDriver) w).getProjectile_speed()));
                }
                else if(w instanceof Laser){
                    fired.add(new Beam(this.location, w.getDamage()));
                }
            }
        }

        return fired;
    }

    // check if any weapon is ready to fire
    public boolean anyReadyToFire(){
        for(Weapon w : this.weapons){
            if (w.readyToFire()){
                return true;
            }
        }

        return false;
    }

    public ArrayList<Contact> getNearby_enemies() {
        return nearby_enemies;
    }

    public ArrayList<Contact> getOn_collision_course() {
        return on_collision_course;
    }

    public float getMax_weapon_range() {
        return max_weapon_range;
    }

    public float getOptimal_weapon_range() {
        return optimal_weapon_range;
    }

    public ArrayList<Contact> getContacts(){
        return this.contacts;
    }

    public Location getLocation(){
        return this.location;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
