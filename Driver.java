public class Driver {
   public static void main(String[] args) {
      
      Simulation FIFO = new FIFOSimulation();
      Simulation MLFQ = new MLFQSimulation();
      Simulation SJF = new SJFSimulation();
      FIFO.run();
      Simulation.resetTime();
      MLFQ.run();
      Simulation.resetTime();
      SJF.run();
      System.out.println("FIFO Scheduler avg throughput: " + FIFO.getThroughput());
      System.out.println("MLFQ Scheduler avg throughput: " + MLFQ.getThroughput());
      System.out.println("SJF Scheduler avg throughput: " + SJF.getThroughput());      
   }     
}