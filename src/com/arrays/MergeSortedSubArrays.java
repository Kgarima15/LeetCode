package com.arrays;

public class MergeSortedSubArrays {

    public static void main(String args[]) {
        int[] arr = {1, 3, 5, 7, 9, 11, 0, 4, 6, 8};
        int endIndex = 5;
        int temp[] = new int[arr.length];

        int i = 0;
        int j = endIndex+1;
        int k = 0;

        while(i<= endIndex && j < arr.length){
            if(arr[i] > arr[j]){
                temp[k++]=arr[j];
                j++;
            }
            else if(arr[i] < arr[j]) {
                temp[k++]=arr[i];
                i++;
            }

            else{
                temp[k++]=arr[i];
                temp[k++]=arr[j];
                i++;
                j++;
            }
        }

        while(i<=endIndex){
            temp[k++]=arr[i++];
        }

        while(j<arr.length){
            temp[k++]=arr[j++];
        }

        for(int m = 0; m<arr.length;m++){
            arr[m] = temp[m];
        }

    }
}
