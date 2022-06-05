package com.arrays;

public class MaxConsecutiveOnes {
    public static void main(String args[]) {
        int[] A = {1,1,1,0,9,8,1,1,1,1};
        int consec = 0;
        int maxSoFar = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                consec++;
            } else {
                if (consec > maxSoFar) {
                    maxSoFar = consec;
                }
                consec = 0;

            }
        }
        if (consec > maxSoFar) {
            maxSoFar = consec;
        }
        System.out.println(maxSoFar);
    }
}
