package examples;

import com.harium.suneidesis.behavior.Agent;
import com.harium.suneidesis.concept.measurement.Threshold;
import com.harium.suneidesis.task.Task;

public class AgentExample {

    public static void main(String[] args) {
        Agent agent = new Agent("Agent");

        agent.addTask(new Task() {
            boolean started = false;

            @Override
            public boolean canStart() {
                return true;
            }

            @Override
            public boolean isInProgress() {
                return started;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public boolean start() {
                started = true;
                return true;
            }
        });

        Threshold hunger = new Threshold().threshold("0.1");
        hunger.min("0").max("1").value("1");

        agent.set("hunger", hunger);

        if (!agent.update()) {
            Threshold threshold = new Threshold().wrap(agent.get("hunger"));

            while (agent.getCurrentTask().isInProgress()) {
                if (threshold.isBelowThreshold()) {
                    System.out.println("I am hungry!");
                    break;
                }

                System.out.println("I am fine.");
                threshold.increment(-0.2);
            }
        }
    }

}
