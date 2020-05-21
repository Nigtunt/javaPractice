package enumAndGenerics;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: YHQ
 * @Date: 2019/11/24 20:23
 */
class teacher{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public teacher(int id) {
        this.id = id;
    }
}
public class newtest {

    public static void main(String args[]){
        List<teacher> t  = new ArrayList<>();
        t.add(new teacher(123));
        t.add(new teacher(13));
        t.add(new teacher(1233));

        Collections.sort(t,(o1,o2)->{
            if(o1.getId()>o2.getId()) return 1;
            else if (o1.getId()<o2.getId()) return -1;
            return 0;
        });
        for(teacher teacher : t){
            System.out.println(teacher.getId());
        }
    }
}
