package NIO;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Author: YHQ
 * @Date: 2020/2/21 14:32
 */
public class test {
    @Test
    public void Test(){
        //capacity 分配缓存的大小
        int capacity = 1024;
        ByteBuffer buffer = ByteBuffer.allocate(capacity);

        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        //向缓存中存数据 put()
        buffer.put("Hello World !".getBytes());

        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        // flip()方法切换到读状态
        buffer.flip();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        //从缓存中取数据 get()
//        byte b = buffer.get();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        //rewind()
        buffer.rewind();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());

        //clear()清空缓存
        buffer.clear();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());

        System.out.println((char) buffer.get());
    }
    /**
     * markTest
     */
    @Test
    public void test2(){
        int capacity = 1024;
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);

        byteBuffer.put("hello world!".getBytes());
        byteBuffer.flip();

        byte [] b = new byte[2];

        byteBuffer.get(b);
        System.out.println(new String(b));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("capacity:" + byteBuffer.capacity());
        System.out.println("limit:" + byteBuffer.limit());
        System.out.println("position:" + byteBuffer.position());
        byteBuffer.mark();
        byteBuffer.get(b);
        System.out.println(new String(b));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("capacity:" + byteBuffer.capacity());
        System.out.println("limit:" + byteBuffer.limit());
        System.out.println("position:" + byteBuffer.position());

        //reset()回到mark标记位置Invariants: mark <= position <= limit <= capacity
        byteBuffer.reset();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("capacity:" + byteBuffer.capacity());
        System.out.println("limit:" + byteBuffer.limit());
        System.out.println("position:" + byteBuffer.position());
    }
    /**
     * 直接缓存区
     */
    @Test
    public void test3(){
        //分配直接缓冲区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println(buf.isDirect());
    }
}
