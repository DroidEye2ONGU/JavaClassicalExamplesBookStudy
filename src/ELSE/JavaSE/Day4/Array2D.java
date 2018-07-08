package ELSE.JavaSE.Day4;

public class Array2D {
    public static void main(String[] args) {
        int[][] twoD = new int[4][];
        twoD[0] = new int[4];

       /* for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                System.out.print(twoD[i][j] + "\t");
                if (j == twoD[i].length - 1) System.out.println();
            }
        }*/
        twoD[1] = new int[5];
        twoD[2] = new int[6];
        twoD[3] = new int[7];

        print2DArray(twoD);

        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                twoD[i][j] = (int) (Math.random() * 100);
            }
        }
        print2DArray(twoD);

        System.out.println("----------------------------------------------------------------");

        int[] oneD = new int[4];
        twoD[0] = oneD;
        print2DArray(twoD);

    }

    public static void print2DArray(int[][] twoD) {
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                System.out.print(twoD[i][j] + "\t");
                if (j == twoD[i].length - 1) System.out.println();
            }
        }
    }
}
