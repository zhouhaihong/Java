package algorithm;

/** 回溯算法-解决8皇后问题
 * @Description:
 * @Author: zhh
 * @Date: 2020/1/20
 */
public class Queens8 {
    public static void main(String[] args) {
        System.out.println("回溯算法-8皇后问题");
        Queens8 queens8 = new Queens8();
        queens8.cal8Queens(0);
    }

    int[] result = new int[8];

    public void cal8Queens(int row){
        if(row ==8){//位置摆放完，打印矩阵
            printQueens(result);
            return;
        }
        for (int column = 0; column <8; column++) {
            if(isOk(row, column)){//判断位置是否合适
                result[row] = column;
                cal8Queens(row + 1);//摆放下一行皇后
            }
        }
    }

    /**
     * 8皇后规则实现:
     * 1.行、列不能出现两个皇后
     * 2.对角线上不能出现两个皇后
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column){
        int leftup = column - 1;//左对角线
        int rightup = column + 1;//右对角线
        for (int i = row - 1; i >=0; i--) {
            // 以下对应规则1
            if(result[i] == column){
                return false;
            }
            // 以下对应规则2
            if (leftup >= 0){
                if (result[i] == leftup){
                    return false;
                }
            }
            if(rightup < 8){
                if (result[i] == rightup){
                    return false;
                }
            }
            leftup --;
            rightup ++;
        }

        return true;
    }

    private void printQueens(int[] result){
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if(result[row] == column){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

}
