package gfg.matrix;

import java.util.Scanner;

public class SearchRowAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        search();
    }

    public static void search() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean[] ops = new boolean[t];

        for(int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] mat = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            int x = sc.nextInt();

            int i=0, j=(m-1); boolean found = false;
            while(i < n && j >= 0) {
                int cur = mat[i][j];
                if (x == cur) {
                    ops[k] = true;
                    break;
                }
                else if (x < cur)
                    j--;
                else
                    i++;
            }
        }
        sc.close();

        for (int i = 0; i < t; i++) {
            if (ops[i])
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}