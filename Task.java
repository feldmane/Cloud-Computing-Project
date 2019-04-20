import java.lang.Comparable;
import java.util.Random;

public class Task implements Comparable<Task> {

   public static long time = 0;
      
   private long startTime;
   private long length;
   private long timeRemaining;
   private long firstTimeRun;
   private double throughput;
   private int priority;
   private int timeslice;
   private Random r;
   
   public Task (long st, long l) {
      this.startTime = st;
      this.length = l;
      this.timeRemaining = l;
      this.firstTimeRun = -1;
      this.throughput = -1;
      this.priority = 64;
      this.timeslice = 2;
      this.r = new Random();
   }
   
   public int run (boolean blocking) {
      int counter = 0;
      this.firstTimeRun = Task.time;
      while (timeRemaining > 0) {
         time++;
         timeRemaining--;
         counter++;
         if (blocking) {
            if (r.nextFloat() < 0.01) {
               return -1;
            } 
            if (counter == this.timeslice) {
               return 1;
            }
         }
      }
      this.throughput = Task.time - this.startTime;
      return 0;
   }
   
   public long getStartTime() {
      return this.startTime;
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
      return other.getPriority() - this.priority;
   }
   
   public static void resetTime() {
      Task.time = 0;
   }
}