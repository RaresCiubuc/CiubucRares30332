package Lab4.Exercise1;

public class ExecutionThread extends Thread{
    
    private int activityMin, activityMax;
    private int sleep;
    private Integer monitor;
    private boolean isRunning;

    public ExecutionThread(Integer monitor, int activityMin, int activityMax, int sleep){
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleep = sleep;
        this.monitor = monitor;
        isRunning = true;
    }

    public void run(){
        System.out.println(this.getName() + " - STATE1");
        if(this.getName().equals("Thread-0")){
            synchronized (monitor){
                System.out.println(this.getName() + " - STATE2");
                int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
                
                for(int i = 0; i <= k * 1000000; i++){
                    i++;
                    i--;
                }
            }
            
            System.out.println(this.getName() + " - STATE3");
        }

        if(this.getName().equals("Thread-1")){
            try{
                this.sleep(sleep*50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
            System.out.println(this.getName() + " - STATE2");
            
            synchronized (monitor){
                System.out.println(this.getName() + " - STATE3");
                int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
                
                for(int i = 0; i <= k * 1000000; i++){
                    i++;
                    i--;
                }
            }
//while Running) {
                System.out.println(this.getName() + " - STATE4");

                System.out.println(this.getName() + " - STATE5");
//            }
        }
    }

}
