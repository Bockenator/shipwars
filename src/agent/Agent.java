package agent;

public abstract class Agent implements Runnable{
    Thread agent_thread;
    String agent_thread_name;
    String agent_name;

    public Agent(String agent_name){
        this.agent_name = agent_name;
        init();
    }

    private void init(){
        this.agent_thread_name = this.agent_name+"_THREAD";
    }

    public void start(){
        System.out.println("STARTING THREAD: "+agent_thread_name);
        if (agent_thread == null){
            agent_thread = new Thread(this, agent_thread_name);
            agent_thread.start();
        }
    }

    public void run(){
        System.out.println("DEFAULT AGENT THREAD "+agent_thread_name+" RUNNING");

        try{
            Thread.sleep(50);
        }
        catch(InterruptedException e){
            System.out.println("INTERRUPTED THREAD: "+agent_thread_name);
        }

    }

    public String toString(){
        return this.agent_name;
    }
}
