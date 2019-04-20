import java.util.PriorityQueue;

public class MLFQSimulation extends Simulation{

   public MLFQSimulation() {
      super();
      this.readyQueue = new PriorityQueue<>();
   }
   
   public void run() {
      int counter = 0;
      for (int i = 0; i < NUMBER_OF_JOBS; i++) {
         this.initializeJob();
         while (this.readyQueue.peek() != null) {
            Task current = this.readyQueue.poll();
            int status = current.run(true);
            if (status < 0) {
               int newPriority = current.getPriority() - 1;
               if (newPriority < 0) {
                  newPriority = 0;
               }
               current.setPriority(newPriority);
            }
            if (status != 0) {
               this.readyQueue.add(current);
            } else {
               this.avgThroughput += current.getThroughput();
            }
         }
      }
      this.avgThroughput /= (NUMBER_OF_JOBS * TASKS_PER_JOB);
   }
}