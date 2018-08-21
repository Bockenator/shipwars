package ship.section;

public abstract class Section {

    private float mass;

    public Section(float mass){
        this.mass = mass;
    }

    public float getMass(){
        return this.mass;
    }
}
