package ship.section;

// engine sections propel ships by generating some force F and using the ship mass m to work out acceleration (F = ma)
public class EngineSection extends Section{

    // engine section parameters
    private float max_force;
    private float current_acceleration = 0;
    private float force_generated = 0;

    // constructor
    public EngineSection(float max_force, float mass) {
        super(mass);
        this.max_force = max_force;
    }

    // force can go up to max reactor force generation
    public float increaseForce(float total_mass, float force_increment){
        if ((force_generated + force_increment) <= max_force){
            force_generated+=force_increment;
            current_acceleration = force_generated/total_mass;
        }

        return current_acceleration;
    }

    // force cannot be negative (reversing is done through 'flip-and-burn'
    public float decreaseForce(float total_mass, float force_increment){
        if ((force_generated-force_increment) >= 0){
            force_generated-=force_increment;
            current_acceleration = force_generated/total_mass;
        }

        return current_acceleration;
    }
}
