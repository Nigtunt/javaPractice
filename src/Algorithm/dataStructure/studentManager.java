package Algorithm.dataStructure;

import javax.naming.Name;

/**
 * @Author: YHQ
 * @Date: 2019/11/2 22:37
 */
public class studentManager {
    private LinkList students = null;
    public void create(){
        students = new LinkList();
    }
    public void add(Object name){
        students.add(name);
    }
    public void remove(int index){
        students.del(index);
    }
    public void change(Object name, int index){
        students.update(name,index);
    }
    public int find(Object name){
        for (int i = 0; i < students.getSize(); i++) {
            if (students.get(i).equals(name)){
                return i;
            }
        }
        System.out.println("无此学生");
        return -1;
    }
    public boolean find(int [][]nums,int target){
        int j = nums[0].length-1;
        int i = 0;
        while(j>=0&&i<nums.length){
            if (nums[i][j]<target){
                i++;
            }else if(nums[i][j]>target){
                j--;
            }else
                return true;
        }
        return false;
    }
    public static void main(String args[]){
        studentManager s = new studentManager();
        s.create();
        for (int i = 1; i < 10; i++) {
            s.add("学生"+i);
        }
        s.remove(2);
        System.out.println(s.find("学生5"));
        System.out.println(s.find(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},7));

    }
}
