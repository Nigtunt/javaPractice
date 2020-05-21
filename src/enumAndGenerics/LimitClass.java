package enumAndGenerics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class LimitClass <T extends List>{
    public static void main(String args[]){
        LimitClass <ArrayList> l1=new LimitClass<>();
        LimitClass<LinkedList> l2=new LimitClass<>();

    }
}
