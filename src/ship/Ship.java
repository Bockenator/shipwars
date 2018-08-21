package ship;
import ship.section.*;
import utilities.Contact;
import utilities.Location;

import java.util.ArrayList;
import java.util.Collections;

public class Ship {
    String name;
    Location location;
    ArrayList<Contact> contacts;
    int contact_tracker = 1;
    Section [] sections;
    EngineSection engine;
    ShipSize ship_size;
    boolean has_engine = false;
    private float mass;
    private float acceleration = 0;
    //weapon range data
    private float max_weapon_range;
    private float optimal_weapon_range;
    private float min_weapon_range;

    public Ship(Section [] sections, String name) {
        this.sections = sections;
        this.name = name;
        init();
    }

    public void init(){
        if (!(checkForEngine(this.sections))) {
            System.out.println("WARNING: No Engine on ship "+this.toString());
        }
        calcWeight();
        calcWeaponRanges();
        this.location = new Location(0,0,0);
    }

    //TODO: UPDATE
    public void accelerate(float force){
        if(has_engine){
            engine.increaseForce(mass, force);
        }
    }

    //TODO: UPDATE
    public void deccelerate(float force){
        if(has_engine){
            engine.decreaseForce(mass, force);
        }
    }

    public Location getLocation(){
        return this.location;
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

    //check that the ship has an engine and set the engine
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

    //calculate the total TODO: MASS
    private void calcWeight(){
        float cum_weight = 0;
        for(Section s : sections){
            cum_weight+=s.getMass();
        }
        this.mass = cum_weight;
    }

    private void calcWeaponRanges(){

        ArrayList<Float> ranges = new ArrayList<>();

        //loop over every hardpoint section and get the weapon range values
        for (Section s : this.sections){

            if (s instanceof HardpointSection){
                ranges.addAll(((HardpointSection) s).getMaxWeaponRange());
                ranges.addAll(((HardpointSection) s).getMinimumWeaponRange());
            }
        }

        //set max and min based on the values of all weapon ranges
        this.max_weapon_range = Collections.max(ranges);
        this.min_weapon_range = Collections.min(ranges);

        //TODO: FIND A BETTER WAY TO REPRESENT OPTIMUM STRIKE DISTANCE
        this.optimal_weapon_range = this.min_weapon_range + (this.max_weapon_range - this.min_weapon_range)/2;

    }

    public void simpleTrackContacts(Location [] new_contact_locations){

        //assume all current contacts are invalid
        for (Contact c : this.contacts){
            c.setRecently_updated(false);
        }

        //update contacts and create a new one if needed
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
            //if the location is not within the threshold of previous locations then create a new contact for it
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

    }

    public float getMax_weapon_range() {
        return max_weapon_range;
    }

    public float getOptimal_weapon_range() {
        return optimal_weapon_range;
    }

    public float getMin_weapon_range() {
        return min_weapon_range;
    }

    public ArrayList<Contact> getContacts(){
        return this.contacts;
    }


    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
