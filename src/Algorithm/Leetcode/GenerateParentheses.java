package Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.List;

//产出括号
public class GenerateParentheses {
    private List<String> list = new ArrayList<String>();

    public  List<String> generateParenthesis(int n) {
        if(n==0)
            return list;
        else
        {
            add(n,"(",1);//调用递归函数 并填入初始值
            return list;
        }
    }

    public void add(int n,String s,int count)
    {
        if(s.length()==n*2-1 )   //递归停止条件
        {
            if(count==1)//如果此时 count为1 说明字符串符合条件
            {
                list.add(s+")");
                return;
            }
            return;
        }

        for(int i=0;i<2;i++)//这层for循环用来生成 i==0时"(" 或 i==1时")"
        {
            if(count>0)
            {
                if(i==0)
                    add(n,s+"(",count+1);
                else
                    add(n,s+")",count-1);
            }
            else
            {
                if(i==0)
                    add(n,s+"(",count+1);
            }

        }
    }
}
