package ship.hardpoint.weapon.laser;

import ship.hardpoint.Hardpoint;
import ship.hardpoint.weapon.Weapon;

public class Laser implements Hardpoint, Weapon {
    private float damage;

    //cooldown in system time
    private float cooldown;

    //range in km
    private float range;

    public Laser(float damage, float cooldown, float range) {
        this.damage = damage;
        this.cooldown = cooldown;
        this.range = range;
    }

    //TODO: Complete firing code
    public void fire(){

    }
}
