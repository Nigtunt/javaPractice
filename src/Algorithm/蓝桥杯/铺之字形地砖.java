package Algorithm.蓝桥杯;

import java.util.Scanner;

public class 铺之字形地砖 {
    public static void main(String args[]){
        final int right = 0;
        final int leftdown = 1;
        final int down = 2;
        final int rightup = 3;
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int [][] cc=new int [n][m];
        for (int i = 0; i < cc.length; i++) {
            for (int j = 0; j < cc[i].length; j++) {
                cc[i][j]=s.nextInt();
            }
        }
        int type=right;
        for (int i=0,j=0;;){
            type%=4;
            System.out.print(cc[i][j]);
            if(type == right){
                if (j+1>=m&&i+1>=n){
                    break;
                }else if(j+1>=m&&i+1<n){
                    i++;
                }else{
                    j++;
                }
            }else if(type == leftdown){
                if (j+1>=m&&i+1>=n){
                    break;
                }
                while(i+1<n&&j-1>=0){
                    i++;
                    j--;
                    if(j!=0&&i!=n-1)
                        System.out.print(cc[i][j]);
                }
            }else if(type == down){
                if (j+1>=m&&i+1>=n){
                    break;
                }else if(i+1>=n&&j+1<m){
                    j++;
                }else{
                    i++;
                }
            }else if(type==rightup){
                if (j+1>=m&&i+1>=n) {
                    break;
                }while(j+1<m&&i-1>=0){
                    i--;
                    j++;
                    if(i!=0&&j!=m-1)
                    System.out.print(cc[i][j]);
                }
            }
            type++;
        }
        String path=s.nextLine();
    }
}
