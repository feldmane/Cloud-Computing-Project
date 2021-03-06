import java.lang.Comparable;
import java.util.Random;

public class Task implements Comparable<Task> {
      
   private long startTime;
   private long length;
   private long timeRemaining;
   private double throughput;
   private int priority;
   private int timeslice;
   private Random r;
   private Simulation simulation;
   
   public Task (long st, long l, Simulation s) {
      this.startTime = st;
      this.length = l;
      this.simulation = s;
      this.timeRemaining = l;
      this.throughput = -1;
      this.priority = 64;
      this.timeslice = 2;
      this.r = new Random(1);
   }
   
   public int run (boolean blocking) {
      int counter = 0;
      while (timeRemaining > 0) {
         Simulation.time++;
         this.timeRemaining--;
         counter++;
         if (blocking) {
            if (r.nextFloat() < 0.2) {
               return -1;
            } 
            if (counter == this.timeslice) {
               return 1;
            }
         }
      }
      this.throughput = Simulation.time - this.startTime;
      return 0;
   }
   
   public long getStartTime() {
      return this.startTime;
   }
   
   public long getLength() {
      return this.length;
   }
   
   public double getThroughput() {
      return this.throughput;
   }
   
   public int getPriority() {
      return this.priority;
   }
   
   public void setPriority(int p) {
      this.priority = p;
   }
   
   public int compareTo(Task other) {
      if (this.simulation instanceof MLFQSimulation) {
         return other.getPriority() - this.priority;
      } else {
         return (int)this.length - (int)other.getLength();
      }
   }
}