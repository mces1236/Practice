package gfg.array;

import java.util.Scanner;

/**
 * Created by chaitanya on 31/05/17.
 */
public class OddOccurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfTestCases = sc.nextInt();

        int[] op = new int[noOfTestCases];

        for(int i = 0; i < noOfTestCases; i++) {
            int arrSize = sc.nextInt();

            int oddOccurance = 0;
            for(int j = 0; j < arrSize; j++) {
                int ele = sc.nextInt();
                oddOccurance = oddOccurance ^ ele;
            }
            op[i] = oddOccurance;
        }

        sc.close();

        for(int i = 0; i < noOfTestCases; i++)
            System.out.println(op[i]);
    }
}
