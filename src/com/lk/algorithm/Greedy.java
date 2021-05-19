package com.lk.algorithm;



/**
 * @author by LiuKui
 * @date 2021/4/3.
 */

public class Greedy {
    static int N = 5, M = 1000;//N为点数量
    static int[][] c = new int[N + 1][N + 1];//存取所有有向图的权值
    static int[] dist = new int[N + 1];//记录源点到目标点的距离
    static int[] prev = new int[N + 1];//记录最短路径经过的点

    public static void main(String[] args) {
        int v = 1;
        init();//初始化数组，v表示源点，表示终点
        Dijkstra(N, 1, dist, prev, c);
        System.out.println("输出:");
        for (int i = 2; i <= N; i++) {
            System.out.println("从1出发到" + i + "的最短距离为:" + dist[i]);
        }
        System.out.println("=======================");
        for (int i = 2; i <= N; i++) {
            System.out.print("从1出发到" + i + "的最短路径为:");
            Traceback(v, i, prev);
            System.out.println(" ");
        }
    }


    public static void Dijkstra(int n, int v, int[] dist, int[] prev, int c[][]) {
        Boolean[] s = new Boolean[N + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = c[v][i];//dist[i]表示当前从源到顶点i的最短特殊路径长度

            s[i] = false;

            if (dist[i] == M) {
                prev[i] = 0;//记录从源到顶点i的最短路径i的前一个顶点
            } else {
                prev[i] = v;
            }
        }

        dist[v] = 0;
        s[v] = true;

        for (int i = 1; i < n; i++) {
            int temp = M;
            int u = v;//上一顶点

            //取出V-S中具有最短特殊路径长度的顶点u
            for (int j = 1; j <= n; j++) {
                if ((!s[j]) && (dist[j] < temp)) {
                    u = j;
                    temp = dist[j];
                }
            }

            s[u] = true;

            //根据作出的贪心选择更新Dist值
            for (int j = 1; j <= n; j++) {
                if ((!s[j]) && (c[u][j] < M)) {
                    int newdist = dist[u] + c[u][j];
                    if (newdist < dist[j]) {
                        dist[j] = newdist;
                        prev[j] = u;
                    }
                }
            }
        }
    }

    //输出最短路径 v源点，i终点
    static void Traceback(int v, int i, int[] prev) {
        if (v == i) {
            System.out.print(i);
            return;
        } else {
            Traceback(v, prev[i], prev);
            System.out.print("-->" + i);
        }

    }

    public static void init() {
        for (int i = 1; i <= N; i++) {
            dist[i] = 0;
            for (int j = 1; j <= N; j++) {
                c[i][j] = M;
            }
        }
        //为了测试方便，直接码出来了
        c[1][2] = 10;
        c[1][4] = 30;
        c[1][5] = 100;
        c[2][3] = 50;
        c[3][5] = 10;
        c[4][5] = 60;
        c[4][3] = 20;

    }
}