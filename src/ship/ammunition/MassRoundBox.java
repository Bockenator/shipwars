package ship.ammunition;

public class MassRoundBox {
    int remaining_ammo;
    private float damage;

    public MassRoundBox(int remaining_ammo, float damage) {
        this.remaining_ammo = remaining_ammo;
        this.damage = damage;
    }

    public void consumeAmmo(int number_consumed){
        int ammo_count = remaining_ammo-=number_consumed;
        if (ammo_count <= 0){
            remaining_ammo = ammo_count;
        }
    }

    public float getDamage() {
        return damage;
    }
}
