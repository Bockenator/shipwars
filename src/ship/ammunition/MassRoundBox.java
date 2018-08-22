package ship.ammunition;

// ammunition for mass drivers is stored in MassRoundBoxes
public class MassRoundBox {

    // remaining ammunition in box (when this is 0, the weapon cannot fire anymore)
    int remaining_ammo;
    // damage for each individual round
    private float damage;

    // constructor
    public MassRoundBox(int remaining_ammo, float damage) {
        this.remaining_ammo = remaining_ammo;
        this.damage = damage;
    }

    // consume n rounds from the ammunition box by updating the remaining_ammo int
    public void consumeAmmo(int n){
        int ammo_count = remaining_ammo-=n;
        if (ammo_count <= 0){
            remaining_ammo = ammo_count;
        }
    }

    public float getDamage() {
        return damage;
    }
}
