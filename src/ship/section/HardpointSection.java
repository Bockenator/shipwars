package ship.section;
import ship.ammunition.Ammunition;
import ship.hardpoint.*;

import java.util.ArrayList;

// hardpoint sections are sections which store weapons and contain ammunition for those weapons
public class HardpointSection extends Section{

    // hardpoint structures (currently only weapons)
    Hardpoint [] hardpoints;
    // ammunition for weapons
    Ammunition [] ammunitions;
    // maximum ammunition storage
    private int max_ammo;

    // constructor
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
