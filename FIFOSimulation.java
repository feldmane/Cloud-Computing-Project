import java.util.ArrayDeque;
import java.util.Random;

public class FIFOSimulation extends Simulation{
   
   public FIFOSimulation() {
      super();
      this.readyQueue = new ArrayDeque<>();
   }
   
   public void run() {
      for (int i = 0; i < NUMBER_OF_JOBS; i++) {
         this.initializeJob();
         while (this.readyQueue.peek() != null) {
            Task current = this.readyQueue.poll();
            current.run(false);
            this.avgThroughput += current.getThroughput();
         }
      }
      this.avgThroughput /= (NUMBER_OF_JOBS * TASKS_PER_JOB);
   }
}