package gfg.array;

import java.util.Scanner;

/**
 * Created by chaitanya on 31/05/17.
 */
public class MajorityElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int noOfTestCases = sc.nextInt();

        String[] op = new String[noOfTestCases];

        for(int i = 0; i < noOfTestCases; i++) {
            int arrSize = sc.nextInt();

            int[] arr = new int[arrSize];

            for(int j = 0; j < arrSize; j++) {
                arr[j] = sc.nextInt();
            }

            int count = 0, pre = -1;
            for(int j = 0; j < arrSize; j++) {
                if(count == 0) {pre = arr[j]; count++;}
                else if(pre == arr[j]) count++;
                else count--;
            }

            if(count > 0) {
                count = 0;
                for (int j = 0; j < arrSize; j++) {
                    if ( pre == arr[j] ) {
                        count++;
                    }
                }
            }

            if(count > (arrSize/2)) {
                op[i] = pre + "";
            } else {
                op[i] = "NO Majority Element";
            }

        }

        sc.close();

        for(int i = 0; i < noOfTestCases; i++)
            System.out.println(op[i]);
    }
}
