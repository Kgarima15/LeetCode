package com.arrays;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int A[] = new int[]{1,-2,3,4,5,3,4,-1};
        int k = 3;

        int i = 0;
        int j = k;
        int maxInK = A[0];
        int[] result = new int[A.length - k + 1];
        for(i=1;i<k;i++){
            if(A[i]>maxInK){
                maxInK = A[i];
            }
        }
        result[0] = maxInK;
        int max = maxInK;
        for(i = 0,j=k;j<A.length;i++,j++){
            if(A[i]==max && A[j]>=A[i])
                max=A[j];
            if(A[i]==max && A[j]<A[i])
                max = findMax(A,i+1,k);
            if(A[j]>max)
                max=A[j];
            result[i+1] = max;
        }
       System.out.println("result"+ result);
    }

    public static int findMax(int[] A, int i, int k){
        int max = A[i];
        while(k-- >0){
            if(A[i]>max)
                max = A[i];
            i++;
        }
        return max;
    }
}
