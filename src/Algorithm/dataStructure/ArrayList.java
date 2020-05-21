package Algorithm.dataStructure;

import java.util.Random;

/**
 * @Author: YHQ
 * @Date: 2019/11/2 19:06
 */
public class ArrayList {
    private int length = 10;
    private int[] datas = new int[length];
    private int size = 0;

    public void add(int data){
        if(this.size >= this.length) {
            length+=10;
            int[] temp = new int[length];
            for(int i = 0 ; i < size ; i++){
                temp[i] = this.datas[i];
            }
            this.datas = temp;
        }
        this.datas[this.size] = data;
        this.size++;
    }

    public void remove(int index){
        if(index < this.size) {
            for (int i = index; i < this.size - 1; i++) {
                this.datas[i] = this.datas[i + 1];
            }
            this.size--;
        }else{
            System.out.printf("没有第%d个元素",index);
        }
    }

    public Integer get(int index){
        if(index < this.size) {
            return this.datas[index];
        }
        System.out.printf("没有第%d个元素",index);
        return null;
    }

    public int size(){
        return this.size;
    }
    public static void main(String args[]){
        ArrayList a = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < 500; i++) {
            a.add(r.nextInt(50));
        }
        System.out.println();
        a.remove(50);
        a.get(30);
        for (int i = 0; i < 500; i++) {
            a.add(r.nextInt(50));
        }
    }
}
