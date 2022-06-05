package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrimesUpTillN {

    public static void main(String[] args){

        int n = 10;
        List<Integer> result = new ArrayList<Integer>();
        if(n>=2) {
            result.add(2);

        }
        if(n>=3) {
            result.add(3);

        }
        if(n>=5) {
            result.add(5);

        }
        for(int i = 7;i<= n;i++){
            if(isPrime(i))
                result.add(i);

        }
        System.out.println(result);
    }

    static boolean isPrime(int x) {
        for(int i=2; i<x;i++){
            if(x%i == 0)
                return false;
        }
        return true;
    }

}
