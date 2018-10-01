import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] leftRotation(int[] a, int d) {
        int len = a.length, ts = 0, pre = a[0], np = 0;
        if (len > 0 && len > d) {
            for (int i = 0; i < d && ts < len; ) {
                np = ((len + np - d) % len);

                int temp = a[np];
                a[np] = pre;
                pre = temp;

                if (np == i) {
                    np = ++i;
                    pre = a[i];
                }

                ts++;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
