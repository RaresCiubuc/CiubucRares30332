package Lab4.Example4;

public class Main {
    public static void main(String[] args) {

        Integer monitorP6 = 0;
        Integer monitorP10 = 1;

        int[] activity1 = { 2, 3 };
        int[] activity2 = { 3, 5 };
        int[] activity3 = { 4, 6 };

        ExecutionThread executionThread = new ExecutionThread(7,monitorP6, monitorP10, activity1);
        executionThread.start();
        new ExecutionThread(0,monitorP6, monitorP10, activity2, executionThread).start();
        new ExecutionThread(0,monitorP6, monitorP10,  activity3, executionThread).start();


    }
}
