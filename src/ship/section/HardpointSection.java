package ship.section;
import ship.ammunition.Ammunition;
import ship.hardpoint.*;

import java.util.ArrayList;

public class HardpointSection extends Section{

    Hardpoint [] hardpoints;
    Ammunition [] ammunitions;
    private int max_ammo;

    public HardpointSection(Hardpoint[] hardpoints, Ammunition[] ammunitions, int max_ammo, float mass) {
        super(mass);
        this.hardpoints = hardpoints;
        this.ammunitions = ammunitions;
        this.max_ammo = max_ammo;
    }

    //TODO: IMPLEMENT
    public void fire(){

    }


    //TODO: IMPLEMENT
    public ArrayList<Float> getMaxWeaponRange(){
        return null;
    }

    //TODO: IMPLEMENT
    public ArrayList<Float> getOptimalWeaponRange(){
        return null;
    }

    //TODO: IMPLEMENT
    public ArrayList<Float> getMinimumWeaponRange(){
        return null;
    }


}
