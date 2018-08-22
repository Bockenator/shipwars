package ship.hardpoint.weapon.laser;

import ship.hardpoint.weapon.Weapon;

// laser weapon class which is a weapon mounted on hardpoints
public class Laser extends Weapon{


    // constructor
    public Laser(float cooldown, float damage, float range) {
        super(cooldown, damage, range);
    }

}
