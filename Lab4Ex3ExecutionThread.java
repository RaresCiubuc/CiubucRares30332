package Lab4.Example3;

public class ExecutionThread extends Thread {

    final Integer monitor;
    int activitymax, activitymin;
    int sleep;

    public ExecutionThread(int sleep, Integer monitor, int activitymin, int activitymax) {
        this.monitor = monitor;
        this.activitymax = activitymax;
        this.activitymin = activitymin;
        this.sleep = sleep;

    }

    public void run() {

        while (true) {
            System.out.println(this.getName() + " - STATE 1");

            synchronized (monitor) {
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activitymax - activitymin) + activitymin);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            }

            System.out.println(this.getName() + " - STATE 3");

            try {
                Thread.sleep(sleep);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " - STATE 4");
        }
    }
}



