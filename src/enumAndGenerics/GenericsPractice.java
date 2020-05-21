package enumAndGenerics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericsPractice <T>{
    public void dosomething(GenericsPractice <? extends List<Object>> a){
        System.out.println(a.getClass().getName());
    }
    public static void main(String args[]){
        GenericsPractice <? extends List<Object>> a=new GenericsPractice<ArrayList<Object>>();
        a.dosomething(new GenericsPractice<ArrayList<Object>>());
        a.dosomething(new GenericsPractice<LinkedList<Object>>());
        GenericsPractice <? super List<Object>> a2 = null;
        a2=new GenericsPractice<Object>();

    }
}
