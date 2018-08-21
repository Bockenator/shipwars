package agent.planner.truthvariable;

import utilities.Location;

public class CollisionImminent extends TruthVariable{
    private Location potential_collision;

    public CollisionImminent(Location potential_collision){
        this.potential_collision = potential_collision;
    }
}
