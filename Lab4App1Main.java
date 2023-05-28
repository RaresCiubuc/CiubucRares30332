package Lab4.Exercise1;

public class Main {
    public static void main(String[] args) {
        int monitor = 0;
        new ExecutionThread(monitor, 3,6, 0).start();
        new ExecutionThread(monitor, 1,5, 3).start();
    }
}
