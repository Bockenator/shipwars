package agent;


import action.Action;
import agent.planner.SubsumptionShipPlanner;
import ship.Ship;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ShipCaptainAgent extends Agent implements Observer {
    private String name;
    private Ship ship;
    private boolean replan_needed = true;

    public ShipCaptainAgent(String name, Ship ship) {
        super(name);
        this.name = name;
        this.ship = ship;
    }

    private ArrayList<Action> generatePlan(){
        //TODO: IF MULTIPLE PLANNERS ARE AVAILABLE MAKE PLANNER TYPE A PARAMETER
        ArrayList<Action> plan = SubsumptionShipPlanner.generatePlan(this.ship);

        return plan;
    }


//    @Override
//    public String toString(){
//        String outstring = this.name + "_OF_" + this.ship.toString();
//        return outstring;
//    }

    @Override
    public void run() {
        System.out.println("SHIP AGENT "+this.agent_thread_name+" RUNNING");
        try{
            if (this.replan_needed){
                System.out.println("AGENT "+this.name+" IS BEGINNING REPLANNING");
                //TODO: ADD REPLANNING CODE HERE
                System.out.println("AGENT "+this.name+" IS FINISHED REPLANNING");
                this.replan_needed = false;
            }
            else {
                this.agent_thread.wait();
            }
        }
        catch(InterruptedException e){
            System.out.println("INTERRUPTED THREAD: "+agent_thread_name);
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        if (this.name.equals(o)){
            this.replan_needed = true;
        }
    }
}
