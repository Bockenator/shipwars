package utilities;

// each ship maintains a list of contacts based on what it can see of the world, each contact has an id and
// other parameters.
public class Contact {
    // as well as ids each contact maintains a location and target classification based on what the ship believes the
    // contact to be
    String contact_id;
    Location location;
    TargetClassification classification;
    // contacts are deleted by the ships if they are not updated
    boolean recently_updated = true;

    // TODO: USE
    float volume;

    // constructor
    public Contact(Location location, int contact_num) {
        this.location = location;
        this.volume = 0;
        this.contact_id = "Contact "+contact_num;
        this.classification = TargetClassification.UNIDENTIFIED;
    }


    public String getContact_id(){
        return this.contact_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public boolean getRecently_updated(){
        return this.recently_updated;
    }

    public void setRecently_updated(boolean recently_updated){
        this.recently_updated = recently_updated;
    }

    public void updateClasssification(TargetClassification updated){
        this.classification = updated;
    }

    public TargetClassification getClassification() {
        return classification;
    }
}
