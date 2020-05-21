package Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YHQ
 * @Date: 2019/12/5 13:32
 */
public class Nqueen {
    List<List<String>> list = new ArrayList<>();
    List<String> str = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int board[] = new int[n];
        queen(board,0,n);
        return list;
    }

    private void queen(int[] board, int i, int n) {
        if (i == n){
            for (int j = 0;j<board.length;j++){
                String s = "";
                for (int k = 0;k<board.length;k++){
                    if (k==board[j]) s += 'Q';
                    else s += '.';
                }
                str.add(s);
            }
            list.add(new ArrayList<>(str));
            str.clear();
        }else {
            for (int j=0;j<n;j++){
                board[i] = j;
                if (noConflicts(board, i)){
                    queen(board,i+1,n);
                }
            }
        }


    }

    private boolean noConflicts(int[] board, int cur) {
        for(int i=0;i<cur;i++){
            if (board[i] == board[cur])
                return false;
            if (cur - i == Math.abs(board[cur]-board[i]))
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        Nqueen b = new Nqueen();
        b.solveNQueens(5);
    }
}
