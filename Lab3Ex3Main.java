package Lab3.ex3; // JOIN() EXAMPLE

public class Main {
    static int sum = 0;

    public static void main(String[] args){
        JoinTestThread w1 = new JoinTestThread("Thread 1",null);
        JoinTestThread w2 = new JoinTestThread("Thread 2",w1);
        w1.start();
        w2.start();
    }
}

class JoinTestThread extends Thread{
    Thread t;
    JoinTestThread(String n, Thread t){
        this.setName(n); this.t=t;
    }
    public void run() {
        System.out.println("Thread "+ this.getName() +" has entered the run() method");
        try {
            if (t != null)
                t.join();
            System.out.println("Thread "+ this.getName() +" executing operation.");
            if (this.getName().equals("Thread 1")) {
                int number1 = 55000;
                int sum = 0;
                for (int i = 1; i <= number1; i++) {
                    if (number1 % i == 0)
                        sum = sum + i;

                }
                Main.sum += sum;
            }

            else if (this.getName().equals("Thread 2")) {
                int number2 = 25000;
                int sum = 0;
                for (int i = 1; i <= number2; i++) {
                    if (number2 % i == 0)
                        sum = sum + i;
                }

                Main.sum += sum;
            }

            System.out.println("The sum is:" + Main.sum);
            System.out.println("Thread "+ this.getName() +" has terminated operation.");
        } catch(Exception e){e.printStackTrace();}
    }
}

