package ship.hardpoint.weapon.weaponprojectile;

import utilities.Location;

public class Projectile implements WeaponProjectile {

    Location location;
    float Speed;
    float damage;

    public Projectile(Location location, float speed, float damage) {
        this.location = location;
        Speed = speed;
        this.damage = damage;
    }


}
