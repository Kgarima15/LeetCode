package com.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class MergeOverlappingIntervals {

    public static void main(String args[]) {
        int[][] sortedMatrix = {{1, 2},{2, 3},{1, 4},{5, 6}};
//        int[][] sortedMatrix = {{1,2},{1,4},{2,3},{5,6}};

        Arrays.sort(sortedMatrix, new ArrayComparator());

        Stack<Interval> stack = new Stack<Interval>();

        for(int i=0;i<sortedMatrix.length;i++){
            if(stack.empty()){
                stack.push(new Interval(sortedMatrix[i][0] , sortedMatrix[i][1]));
            }
            else {
                final var interval = stack.peek();
                if(sortedMatrix[i][0] >= interval.start && sortedMatrix[i][0] <= interval.end) {
                    stack.pop();
                    stack.push(new Interval(interval.start, Math.max(interval.end, sortedMatrix[i][1])));
                }
                else {
                    stack.push(new Interval(sortedMatrix[i][0] , sortedMatrix[i][1]));
                }
            }
        }
        int size = stack.size();
        System.out.println(size);
        final var a = stack.pop();
        System.out.println(a.start +" "+ a.end);
        final var b = stack.pop();
        System.out.println(b.start +" "+ b.end);
    }
}

class ArrayComparator implements Comparator<int[]> {
    public int compare(int[] first, int[] second) {
        if(first[0] > second[0]) {
            return 1;
        } else {
            return - 1;
        }
    }
}