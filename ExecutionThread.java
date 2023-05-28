package Lab4.Example4;

public class ExecutionThread extends Thread {
    final Integer monitorP6, monitorP10;
    int[] activity;
    int sleep;
    int k = 0;
    Thread t;

    public ExecutionThread(int sleep, Integer monitorP6, Integer monitorP10, int[] activity) {
        this.monitorP6 = monitorP6;
        this.monitorP10 = monitorP10;
        this.sleep=sleep;
        this.activity = activity;
        this.sleep = sleep;
    }
    public ExecutionThread(int sleep, Integer monitorP6, Integer monitorP10, int[] activity, Thread t) {
        this.monitorP6 = monitorP6;
        this.monitorP10 = monitorP10;
        this.sleep=sleep;
        this.activity = activity;
        this.sleep = sleep;
        this.t = t;
    }

    public void run() {
        if(this.getName().equals("Thread-0")) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.random() * (activity[1] - activity[0]) + activity[0];
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            synchronized (monitorP6) {
                synchronized (monitorP10) {
                    monitorP6.notify();
                    monitorP10.notify();
                }
            }
            System.out.println(this.getName() + " - STATE 3");

        }

        if(this.getName().equals("Thread-1")) {
            System.out.println(this.getName() + " - STATE 1");
            synchronized (monitorP6) {
                    try {
                        monitorP6.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName() + " - STATE 2");
                    k = (int) Math.random() * (activity[1] - activity[0]) + activity[0];
                    for (int i = 0; i < k * 100000; i++) {
                        i++;
                        i--;
                    }
                    System.out.println(this.getName() + " - STATE 3");

                    if (t != null) {
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }

        if(this.getName().equals("Thread-2")) {
            System.out.println(this.getName() + " - STATE 1");
            synchronized (monitorP10) {
                try {
                    monitorP10.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.random() * (activity[1] - activity[0]) + activity[0];
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                System.out.println(this.getName() + " - STATE 3");

                if(t != null) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}