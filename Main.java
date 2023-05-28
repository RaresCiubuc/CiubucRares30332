package Lab4.Example3;

public class Main {
    public static void main(String args[]){

        Integer monitor = new Integer(1);

        new ExecutionThread(5,monitor,3,6).start();
        new ExecutionThread(3,monitor,4,7).start();
        new ExecutionThread(6,monitor,5,7).start();
    }
}
