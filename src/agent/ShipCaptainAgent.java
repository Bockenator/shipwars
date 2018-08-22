package agent;


import action.Action;
import agent.planner.SubsumptionShipPlanner;
import ship.Ship;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// ShipCaptainAgent controls a single ship
public class ShipCaptainAgent extends Agent implements Observer {

    // agent parameters
    private String name;
    private Ship ship;

    // every time a plan is completed a replan is needed, this variable tracks that
    private boolean replan_needed = true;

    // constructor
    public ShipCaptainAgent(String name, Ship ship) {
        super(name);
        this.name = name;
        this.ship = ship;
    }

    // call a static planner that generates a plan based on ship data
    private ArrayList<Action> generatePlan(){
        //TODO: IF MULTIPLE PLANNERS ARE AVAILABLE MAKE PLANNER TYPE A PARAMETER
        ArrayList<Action> plan = SubsumptionShipPlanner.generatePlan(this.ship);

        return plan;
    }

    // agent run method
    @Override
    public void run() {
        System.out.println("SHIP AGENT "+this.agent_thread_name+" RUNNING");
        try{
            // if the replan boolean is flagged, execute a replan
            if (this.replan_needed){
                System.out.println("AGENT "+this.name+" IS BEGINNING REPLANNING");
                //TODO: ADD REPLANNING CODE HERE
                System.out.println("AGENT "+this.name+" IS FINISHED REPLANNING");
                this.replan_needed = false;
            }
            // otherwise just wait
            else {
                this.agent_thread.wait();
            }
        }
        catch(InterruptedException e){
            System.out.println("INTERRUPTED THREAD: "+agent_thread_name);
        }
    }

    // observer update
    @Override
    public void update(Observable observable, Object o) {
        if (this.name.equals(o)){
            this.replan_needed = true;
        }
    }
}
