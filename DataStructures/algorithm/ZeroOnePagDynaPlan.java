/*********************************************************************************
 * Copyright (c) 2020 中电健康云科技有限公司
 * 版本      DATE                 BY             REMARKS
 * ----  -----------  ---------------  ------------------------------------------
 * 1.0    2020/1/22      zhh           init.
 ********************************************************************************/
package algorithm;

/**
 *  动态规划--解决0-1背包问题
 * @Description:
 * @Author: zhh
 * @Date: 2020/1/22
 */
public class ZeroOnePagDynaPlan {
    public static void main(String[] args) {

    }

    /**
     *
     * @param weight 物品重量
     * @param n 物品个数
     * @param w 背包可承载重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w){
        boolean[][]  states = new boolean[n][w+1];//默认值false
        states[0][0] = true;//不放第一个物品的状态
        if(weight[0] <= w){
            states[0][weight[0]] = true;//放第一个物品的状态。注意：下标从0开始的（表示第一个物品）
        }
        for (int i = 1; i < n; i++) {// 动态规划状态转移：依次取物品来放火不放
            for (int j = 0; j <= w; j++) {// 不把第i个物品放入背包
                if(states[i-1][j] == true){//判断上一层对应列状态是否存在
                    states[i][j] = states[i-1][j]; //由于不放物品，直接将上一层状态赋给下一行
                }
            }
            for (int j = 0; j < w-weight[i]; j++) {//把第i个物品放入背包
                if(states[i-1][j] == true){//由于下一层结果是基于上一层的，所有需要进行该判断
                    states[i][j + weight[i]] = true;//由于放入了物品，所以需要累积
                }
            }
        }
        // 输出结果：从最后一层（数组最后一行）中找出最大的重量
        // 注意要从最后一列（w列）反向查找
        for (int i = w; i >= 0 ; i--) {
            if(states[n-1][i] == true){
                return i;
            }
        }
        return 0;
    }


    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;//不放第一个物品状态
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];//放第一个物品
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移：依次放物品
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i-1][j] >= 0) {
                    states[i][j] = states[i-1][j];
                }
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {//只选择值最大的那一个
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) {
                maxvalue = states[n-1][j];
            }
        }
        return maxvalue;
    }

}
