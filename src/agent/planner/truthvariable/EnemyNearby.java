package agent.planner.truthvariable;

import utilities.Location;

public class EnemyNearby extends TruthVariable {
    private Location enemy;

    public EnemyNearby(Location enemy) {
        this.enemy = enemy;
    }
}
