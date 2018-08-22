package ship.section;

// a ship is made up of multiple sections
public abstract class Section {
    // mass of sections influences acceleration
    private float mass;

    // constructor
    public Section(float mass){
        this.mass = mass;
    }

    public float getMass(){
        return this.mass;
    }
}
