package utilities;

public class Contact {
    String contact_id;
    Location location;
    float volume;
    Target_Classification classification;
    boolean recently_updated = true;

    public Contact(Location location, int contact_num) {
        this.location = location;
        this.volume = 0;
        this.contact_id = "Contact "+contact_num;
        this.classification = Target_Classification.UNIDENTIFIED;
    }

    public void setContact_id(String id){
        this.contact_id = id;
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

    public void updateClasssification(Target_Classification updated){
        this.classification = updated;
    }


}
