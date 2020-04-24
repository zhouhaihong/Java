package algorithm;

/**
 * 回溯算法--解决0-1背包问题
 * @Description: 用到了搜索剪枝的技巧，就是当发现已经选择的物品的重量超过 Wkg 之后，我们就停止继续探测剩下的物品
 * @Author: zhh
 * @Date: 2020/1/20
 */
public class ZeroOnePackage {
    public static void main(String[] args) {

    }
    // 存储背包中物品总重量的最大值
    public int maxW = Integer.MIN_VALUE;

    /**
     *  假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
     *      putInto(0, 0, a, 10, 100)
     * @param i 表示考察到哪个物品了
     * @param cw 表示当前已经装进去的物品的重量和
     * @param items 表示每个物品的重量
     * @param n 物品个数
     * @param w 背包重量
     */
    public void putInto(int i, int cw, int[] items, int n, int w){
        // cw==w表示装满了;i==n表示已经考察完所有的物品
        if(cw == w || i == n){
            if(cw > maxW){
                maxW = cw;
            }
            return;
        }
        // 以下两个递归分别表示当前物品是否装进去
        putInto(i+1, cw, items, n, w);//当前物品不装进背包
        // 已经超过背包可以承受的重量的时候，就不要再装了
        if (cw + items[i] <= w){
            putInto(i+1, cw+items[i], items, n, w);//当前物品装进背包
        }
    }

}
/**
 * 假设三个物品，每个物品在考虑时有两种选择，1-放进包，0-不放
 * 11行代码表示不放进包里。13行代码表示放进包里。
 * 三个物品遍历过程如下：
 * 0 0 0 update maxW
 * 0 0 1 update maxW
 * 0 1 0 update maxW
 * 0 1 1 update maxW
 * 1 0 0 update maxW
 * 1 0 1 update maxW
 * 1 1 0 update maxW
 * 1 1 1 update maxW
 */
