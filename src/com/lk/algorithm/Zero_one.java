package com.lk.algorithm;

/**
 * @author by LiuKui
 * @date 2021/3/30.
 */
public class Zero_one {
    static int packageweight = 25;//背包的总容量
    static int productnum = 6;//物品总数
    static int[] weights = {11, 7, 9, 12, 3, 10};//每个物品的重量
    static int[] values = {10, 5, 7, 9, 2, 12};//每个物品的价值

    public static void main(String[] args) {
        Zero_one zero_one = new Zero_one();

        int[][] m = zero_one.initpkdata();
        int[][] res = zero_one.result(m);

        System.out.println("输出:");
        System.out.println("最大价值：" + res[zero_one.productnum][zero_one.packageweight]);
        System.out.print("装入的物品编号是:");
        zero_one.findproducts(res);
    }

    /**
     * 初始化背包
     * m[i][0] = 0 :表示背包重量为0，不能装东西，因此价值全为0
     * m[0][j] = 0 :表示没有可以装的物品，因此价值为0
     */
    public int[][] initpkdata() {
        int[][] m = new int[this.productnum + 1][this.packageweight + 1];
        for (int i = 0; i <= this.productnum; i++) {
            m[i][0] = 0;
        }
        for (int j = 0; j <= this.packageweight; j++) {
            m[0][j] = 0;
        }
        return m;
    }

    public int[][] result(int[][] arr) {
        for (int i = 1; i <= this.productnum; i++) {
            for (int j = 1; j <= this.packageweight; j++) {
                // 当第i件物品重量大于当前包的容量 则放不进去
                // 所以当前背包所含价值等于前i-1件商品的价值
                if (this.weights[i - 1] > j) {
                    arr[i][j] = arr[i - 1][j];
                }
				/*当第i件物品能放进去时
				1 放入物品，价值为：arr[i-1][j-(int)this.weights.get(i-1)] + (int)this.values.get(i-1)
				2不放入物品，价值为前i-1件物品价值和：arr[i][j] = arr[i-1][j];
				此时最大价值为上述两种方案中最大的一个
				*/
                else {
                    if (arr[i - 1][j] < arr[i - 1][j - this.weights[i - 1]] + this.values[i - 1]) {
                        arr[i][j] = arr[i - 1][j - this.weights[i - 1]] + this.values[i - 1];
                    } else {
                        arr[i][j] = arr[i - 1][j];
                    }
                }
            }
        }
        return arr;
    }

    public void findproducts(int[][] arr) {
        int j = this.packageweight;
        for (int i = 1; i <= this.productnum; i++) {
            if (arr[i][j] > arr[i - 1][j]) {
                System.out.print(i + ",");//输出选中的物品的编号
                j = j - this.weights[i - 1];
                if (j < 0) {
                    break;
                }
            }
        }
    }
}