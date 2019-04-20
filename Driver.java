public class Driver {
   public static void main(String[] args) {
      
      Simulation FIFO = new FIFOSimulation();
      Simulation MLFQ = new MLFQSimulation();
      FIFO.run();
      Task.resetTime();
      MLFQ.run();
      System.out.println("FIFO Scheduler avg throughput: " + FIFO.getThroughput());
      System.out.println("MLFQ Scheduler avg throughput: " + MLFQ.getThroughput());
      
   }     
}