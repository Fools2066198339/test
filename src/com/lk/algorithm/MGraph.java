package com.lk.algorithm;

/**
 * @author by LiuKui
 * @date 2021/4/4.
 */
public class MGraph {
    /*图的邻接矩阵表示*/
    int nodes;  //图中结点数目
    char data[];  //存放结点数据
    int[][] weight;  //存放边

    public MGraph(int ve) {
        nodes = ve;
        data = new char[ve];
        weight = new int[ve][ve];
    }
}