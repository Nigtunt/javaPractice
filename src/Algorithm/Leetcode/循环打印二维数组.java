package Algorithm.Leetcode;

import java.util.ArrayList;

/**
 * @Author: YHQ
 * @Date: 2019/11/3 17:53
 */
public class 循环打印二维数组 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0)  return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0,top = 0,bottom = row - 1,right = col - 1;
        while(left <= right && top <= bottom){
            for(int i = left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            for(int j = top+1;j<=bottom;j++){
                list.add(matrix[j][right]);
            }
            if (top != bottom)
                for(int t = right-1;t>=left;t--){
                    list.add(matrix[bottom][t]);
                }
            if(left != right)
                for(int k = bottom-1;k>top;k--){
                    list.add(matrix[k][left]);
                }
            top++;left++;right--;bottom--;
        }
        return list;
    }
    public static void main(String args[]){
        循环打印二维数组 a=new 循环打印二维数组();
        int b[][]={{1,2,3,4},{5 ,6 ,7 ,8},{9 ,10 ,11 ,12} ,{13 ,14 ,15 ,16}};
        ArrayList list = a.printMatrix(b);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
