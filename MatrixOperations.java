package lab1;

public class MatrixOperations {
    public static int[][] sum(int a[][], int b[][]){
        int[][] newMatrix = new int[a.length][a.length];

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                newMatrix[i][j] = a[i][j] + b[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] product(int a[][], int b[][]){
        int[][] newMatrix = new int[a.length][a.length];

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                int sum = 0;
                for(int k = 0; k < a[i].length; k++){
                    sum += a[i][k] * b[k][j];
                }
                newMatrix[i][j] = sum;
            }
        }
        return newMatrix;
    }

    public static void print(int[][] a){
        for (int[] row: a) {
            for (int x: row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
