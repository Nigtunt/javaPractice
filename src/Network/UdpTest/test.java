package Network.UdpTest;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @Author: YHQ
 * @Date: 2019/12/17 20:41
 */
public class test {
    @Test
    public void test() throws Exception{
        Date d= new Date();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        oout.writeObject(d);
        byte [] bytes = bout.toByteArray();
        System.out.println(new String(bytes));
        ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Date dd = (Date) oin.readObject();
        System.out.println(dd);
    }
}
