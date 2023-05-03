package lab1;

public class Main {

    public static void main(String[] args) {
    //EX1
        Complex a = new Complex(2, 5);
        Complex b = new Complex(4, -1);

        System.out.println("EXERCICE 1:");
        System.out.println("(" + a + ") + " + "(" + b + ") = " + "(" + Complex.sum(a,b) + ")");
        System.out.println("(" + a + ") * " + "(" + b + ") = " + "(" + Complex.product(a,b) + ")");
        System.out.println();
    //EX2

        int[][] A = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int[][] B = {{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};

        int[][] sumAB = MatrixOperations.sum(A,B);
        int[][] productAB = MatrixOperations.product(A,B);

        System.out.println("EXERCICE 2:");
        System.out.println("A + B: ");
        MatrixOperations.print(sumAB);

        System.out.println("A * B: ");
        MatrixOperations.print(productAB);
    }
}
