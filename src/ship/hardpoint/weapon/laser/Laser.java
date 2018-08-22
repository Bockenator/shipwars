package ship.hardpoint.weapon.laser;

import ship.hardpoint.Hardpoint;
import ship.hardpoint.weapon.Weapon;

// laser weapon class which is a weapon mounted on hardpoints
public class Laser implements Hardpoint, Weapon {
    // damage dealt by laser
    private float damage;

    // cooldown in system time
    private float cooldown;

    // range in km
    private float range;

    // constructor
    public Laser(float damage, float cooldown, float range) {
        this.damage = damage;
        this.cooldown = cooldown;
        this.range = range;
    }

    //TODO: COMPLETE
    public void fire(){

    }
}
