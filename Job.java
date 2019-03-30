public class Job implements Runnable{
   
   private long startTime;
   private long length;
   
   public Job (long st, long l) {
      this.startTime = st;
      this.length = l;
   }
   
   public void run () {
      while (System.currentTimeMillis() - startTime < length);
   }
   
}