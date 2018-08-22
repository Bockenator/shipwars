package ship.section;
import ship.ammunition.Ammunition;
import ship.hardpoint.*;
import ship.hardpoint.weapon.Weapon;

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
    public ArrayList<Weapon> getWeapons(){
        ArrayList<Weapon> weapons = new ArrayList<>();

        for (Hardpoint h : this.hardpoints){
            if (h instanceof Weapon){
                weapons.add((Weapon) h);
            }
        }

        return weapons;
    }

    //TODO: CONFIGURE FOR MISSILE RANGES TOO
    // get all the weapon ranges by looping over weapons
    public ArrayList<Float> getMaxWeaponRange(){
        ArrayList<Float> ranges = new ArrayList<>();
        for (Hardpoint h : hardpoints){
            if (h instanceof Weapon){
                ranges.add(((Weapon) h).getRange());
            }
        }

        return ranges;
    }



}
