package ship.hardpoint.weapon.weaponprojectile;

import utilities.Location;

public class Beam implements WeaponProjectile {

    Location location;
    float damage;

    public Beam(Location location, float damage) {
        this.location = location;
        this.damage = damage;
    }

}
