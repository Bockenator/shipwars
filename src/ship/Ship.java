package ship;
import ship.section.*;
import utilities.Contact;
import utilities.Location;

import java.util.ArrayList;

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
        this.location = new Location(0,0,0);
    }

    //TODO: Update this
    public void accelerate(float force){
        if(has_engine){
            engine.increaseForce(mass, force);
        }
    }

    //TODO: Update this
    public void deccelerate(float force){
        if(has_engine){
            engine.decreaseForce(mass, force);
        }
    }

    public Location getLocation(){
        return this.location;
    }

    //TODO: Update this
    public void turn_xy(float increment){
        location.updateFacing_xy(increment);
    }

    //TODO: Update this
    public void turn_xz(float increment){
        location.updateFacing_xy(increment);
    }

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



    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
