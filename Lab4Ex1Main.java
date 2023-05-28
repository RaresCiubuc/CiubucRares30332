package Lab4.Example1;


public class Main {
    public static void main(String[] args) {

        Integer[] monitor = {1,2};

        new ExecutionThread(monitor, 4, 2, 4).start();
        new ExecutionThread(monitor, 3,3,6).start();
        new ExecutionThread(monitor, 5,2,5).start();
    }
}

