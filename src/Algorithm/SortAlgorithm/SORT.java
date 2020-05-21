package Algorithm.SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SORT {
    private int [] bubbleSort(int [] array){
        if(array.length==0) return array;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j <array.length -i; j++) {
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }
    //    从第一个元素开始，该元素可以认为已经被排序；
//    取出下一个元素，在已经排序的元素序列中从后向前扫描；
//    如果该元素（已排序）大于新元素，将该元素移到下一位置；
//    重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
//    将新元素插入到该位置后；
//    重复步骤2~5。
    private int[] insertionSort(int [] array){
        if(array.length==0) return array;
        int current;
        for (int i = 0; i < array.length-1; i++) {
            current=array[i+1];
            int preIndex=i;
            while(preIndex>=0&&current<array[preIndex]){
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            array[preIndex+1]=current;
        }
        return array;
    }
    //将待排序的元素分成两个大小大致相同的两个子集合，分别对两个子集合进行排序，
    //最后将排序好的集合合并
    public int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
    private void QSort(int a[],int start,int end){
        if (start<end){
            int k=partition(a,start,end);
            QSort(a,start,k-1);
            QSort(a,k+1,end);
        }
    }
    private int partition(int a[],int start,int end){
        int pivot = (int) (start + Math.random() * (end - start + 1));
        if(pivot!=start)
            swap(a, pivot, start);
        int smallIndex=start,maxIndex=end+1;
        while(true){
            while(a[start]>a[++smallIndex]&&smallIndex<end) ;
            while(a[start]<a[--maxIndex]);
            if (smallIndex >= maxIndex)
                break;
            swap(a,smallIndex,maxIndex);

        }
        swap(a,start,maxIndex);
        return maxIndex;
    }
    private static void swap(int []a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private int[] selectionSort(int[] array){
        if(array.length==0) return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <array.length ; j++) {
                if(array[minIndex]>array[j])
                    minIndex=j;
            }
            int temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
        return array;
    }
    /*希尔排序
    先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序
    具体算法描述：选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
    按增量序列个数k，对序列进行k 趟排序；
    每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
    分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。*/

    private int[] shellSort(int[] array){
        int len=array.length;
        int temp,gap=len/2;
        while(gap>0){
            for(int i=gap;i<len;i++){
                temp=array[i];
                int preIndex=i-gap;
                while(preIndex>=0&&array[preIndex]>temp){
                    array[preIndex+gap]=array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap]=temp;
            }
            gap/=2;
        }
        return array;
    }
    private int[] CountingSort(int [] array){
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }
    /**
     * 基数排序
     * @param array
     * @return
     */
    public int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;    //提取当年前位的数字
                bucketList.get(num).add(array[j]);   //添加到当前位数字的集合
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();   //提取集合中的所有数，并清空
            }
        }
        return array;
    }
    private ArrayList<Integer> BucketSort(ArrayList<Integer> array,int bucketSize){
        if (array==null||array.size()<2) return array;
        int max = array.get(0),min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize +1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<>());
        }
        for (int i = 0; i < array.size(); i++) {
            int index = (array.get(i)-min) / bucketSize;
            bucketArr.get(index).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1){
                for (int j=0;j<bucketArr.get(i).size();j++){
                    resultArr.add(bucketArr.get(i).get(j));
                }
            }else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i),bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    private static int len;
    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    public int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;      //10,17,5,4,7,9,2,6
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = len/2 - 1; i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 + 1< len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex])
            maxIndex = i * 2 + 2;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    public static void main(String args[]){
        int a[] = new int[10000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*1000000);
        }
        SORT sort=new SORT();
        long start = System.nanoTime();
//        sort.bubbleSort(a);
        System.out.println("bubbleSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
//        sort.insertionSort(a);
        System.out.println("insertionSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
        sort.mergeSort(a);
        System.out.println("mergeSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
        sort.QSort(a,0,a.length-1);
        System.out.println("QSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
//        sort.selectionSort(a);
        System.out.println("selectionSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
        sort.shellSort(a);
        System.out.println("shellSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
//        sort.CountingSort(a);
        System.out.println("CountingSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
//        sort.RadixSort(a);
        System.out.println("RadixSort:"+(System.nanoTime() - start)/1000000.0);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
        sort.HeapSort(a);
        System.out.println("HeapSort:"+(System.nanoTime() - start)/1000000.0);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add((int)(Math.random()*10000));
        }
        start = System.nanoTime();
//        sort.BucketSort(list,10);
        System.out.println("BucketSort:"+(System.nanoTime() - start)/1000000.0);
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*10000);
        }
        start = System.nanoTime();
        Arrays.sort(a);
        System.out.println("Arrays.sort(a):"+(System.nanoTime() - start)/1000000.0);

    }
}
