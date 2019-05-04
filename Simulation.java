import java.util.Queue;
import java.util.Random;

public abstract class Simulation {

   protected final int NUMBER_OF_JOBS = 2;
   
   protected final int TASKS_PER_JOB = 10;
   
   protected Queue<Task> readyQueue;
   
   protected double avgThroughput;
   
   protected Random randomGenerator;
   
   public Simulation() {
      this.avgThroughput = 0;
      this.randomGenerator = new Random(1);
   }
   
   public double getThroughput() {
      return this.avgThroughput;
   }
   
   public long createNewTaskLength() {
      double percentOfShortJobs = 0.7;
      long baseShortJob = 10;
      long baseLongJob = 100;
      int maxOffset = 5;
            
      int getPlusOrMinus = randomGenerator.nextInt(2);
      int plusOrMinus = (getPlusOrMinus == 0) ? -1 : 1;
      
      long offset = randomGenerator.nextInt(maxOffset);
      
      double prob = randomGenerator.nextFloat();

      if (prob < percentOfShortJobs) {
         return baseShortJob + (offset * plusOrMinus);
      } else {
         return baseLongJob + (offset * plusOrMinus);
      }
   }
   
   public void initializeJob() {
      for (int i = 0; i < TASKS_PER_JOB; i++) {
         long length = createNewTaskLength();
         this.readyQueue.add(new Task(Task.time, length, this));
      }
   }
   
   public abstract void run();
   
}