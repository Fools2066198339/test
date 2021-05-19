package com.lk.algorithm;


/**
 * @author by LiuKui
 * @date 2021/4/4.
 */

public class Prim {
    public  static int N =6;
   public static int[] lowcost = new int[N];
   public static int[] mast = new int[N];
   public static int cost = 0;
    public static final int INF = Integer.MAX_VALUE;
   static int[][] graph= new int[][]{
            {0,6,1,5,INF,INF},
            {6,0,5,INF,3,INF},
            {1,5,0,5,6,4},
            {5,INF,5,0,INF,2},
            {INF,3,6,INF,0,6},
            {INF,INF,4,2,6,0}
    };
   static char[] data = new char[]{'1','2','3','4','5','6'};
    public static void main(String[] args) {



    }

   public static void prim() {
       for (int[] i :graph) {

       }
   }
}
