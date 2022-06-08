package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenFruits {
    public static void main(String args[]){

//        2 1 1
//        1 1 0
//        1 0 1
        int matrix[][] = new int[][]{{2,1,1},{1,1,0},{1,0,1}};

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==2){
                    var pair = new Pair(i,j);
                    q.add(pair);
                }
            }
        }
        q.add(new Pair(-1,-1));

        int count = 0;
        while(q.size()> 1) {
            var p = q.remove();
            if(p.i == -1) {
                count++;
                q.add(new Pair(-1,-1));
            }

            q = addToQueue(matrix, p, q);
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==1){
                  System.out.println(" result is -1");
                }
            }
        }
    System.out.println(count);

    }

    private static Queue<Pair> addToQueue(int[][] matrix, Pair p, Queue<Pair> q) {
        int i = p.i;
        int j = p.j;
        if( (i+1) < matrix.length && j>=0 && matrix[i+1][j] == 1) {
            q.add(new Pair(i+1,j));
            matrix[i+1][j] = 2;

        }

        if((i-1) >= 0 && j>=0 && matrix[i-1][j] == 1) {
            q.add(new Pair(i-1,j));
            matrix[i-1][j] = 2;
         }

        if((j+1)< matrix[0].length && i>=0 && matrix[i][j+1] == 1) {
            q.add(new Pair(i,j+1));
            matrix[i][j+1] = 2;
           }

        if((j-1)>=0 && i>=0 && matrix[i][j-1] == 1) {
            q.add(new Pair(i,j-1));
            matrix[i][j-1] = 2;
          }


        return q;
    }
}


class Pair {
    public Integer i;
    public Integer j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
