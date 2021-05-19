package com.lk.algorithm;

import java.util.Scanner;

/**
 * @author by LiuKui
 * @date 2021/3/31.
 */
public class DijstraAlgorithm {
    private static int NIF=9999;
    private static int max=9999;
    private static int dist[]=new int[13];//记录原点到某点最短路径为多少
    //private static int path[]=new int[10];//记录最短路径
    //private static int data[][]=new int[10][10];
    public static void main(String args[]){

        int i,m;
        int a[][]={ //从i到j可直达的路径长度，不可直达的设为无穷大（x）
                {0, 9, 7, 3, 2, NIF, NIF, NIF, NIF, NIF, NIF, NIF},
                {NIF, NIF, NIF, NIF, NIF, 4, 2, 1, NIF, NIF, NIF, NIF},
                {NIF, NIF, 0, NIF, NIF,2,7, NIF, NIF,NIF,NIF,NIF},
                {NIF ,NIF,NIF,0, NIF,NIF,NIF, 11, NIF, NIF,NIF, NIF},
                {NIF, NIF,NIF,NIF,0, NIF, 11, 8,NIF,NIF,NIF,NIF},
                {NIF, NIF, NIF,NIF,NIF,0,NIF,NIF ,6, 5, NIF, NIF},
                {NIF,NIF,NIF,NIF,NIF,NIF, 0, NIF, 4, 3, NIF,NIF},
                {NIF,NIF,NIF,NIF,NIF,NIF, NIF,0, NIF,4, 3,NIF},
                {NIF,NIF,NIF,NIF,NIF,NIF, NIF, NIF, 0, NIF, NIF,4},
                {NIF,NIF,NIF,NIF,NIF,NIF,NIF, NIF,NIF, 0, NIF,2},
                {NIF,NIF,NIF,NIF,NIF,NIF,NIF, NIF,NIF,NIF, 0,5},
                {NIF,NIF,NIF,NIF,NIF,NIF,NIF, NIF,NIF,NIF, NIF,0}
        };


        fpath(a);
        System.out.print("最短路径大小为："+dist[9]);
	    /*   m=froute(a);
	    for(i=m-1;i>=0;i--)
	    	System.out.println("最短路径为:"+path[i]);*/
    }

    public static void fpath(int a[][])
    {
        int i,j,k;
        dist[0]=0;
        for(i=1;i<10;i++)
        {
            k=max;
            for(j=0;j<i;j++)
            {
                if(a[j][i]!=NIF)
                    if((dist[j]+a[j][i])<k)
                        k=dist[j]+a[j][i];
            }
            dist[i]=k;
        }
    }

	/*public static int froute(int a[][])
	{
	    int j,b,k=1,i=9;
	    path[0]=10;
	    while(i>0)
	    {
	        for(j=i-1;j>=0;j--)
	        {
	            if(a[j][i]!=x)
	            {
	                b=dist[i]-a[j][i];
	                if(b==dist[j])
	                {
	                    path[k++]=j+1;
	                    i=j;
	                    break;
	                }
	            }
	        }
	    }
	        return k;
	}*/

}