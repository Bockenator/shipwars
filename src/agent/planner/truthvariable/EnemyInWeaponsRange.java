package agent.planner.truthvariable;

import utilities.Location;

public class EnemyInWeaponsRange extends TruthVariable {
    private Location enemy;

    public EnemyInWeaponsRange(Location enemy) {
        this.enemy = enemy;
    }
}
