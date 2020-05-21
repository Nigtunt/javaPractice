package NIO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

/**
 * @Author: YHQ
 * @Date: 2020/2/21 14:56
 */
public class Channel {
    @Test
    public void test1(){
        FileInputStream fin = null;
        FileOutputStream fout = null;

        FileChannel finChannel = null;
        FileChannel foutChannel = null;
        try {
            fin = new FileInputStream("1.gif");
            fout = new FileOutputStream("2.gif");
            //1. 获得通道
            finChannel = fin.getChannel();
            foutChannel = fout.getChannel();
            //2. 获取缓存
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //3.反复读2.jpg的字节到缓存
            while(finChannel.read(buffer) != -1){
                //4. position定位到开头以便从缓存中获取数据
                buffer.flip();
                //5. 将缓存数据写入通道
                foutChannel.write(buffer);
                //6. 清空缓存position定位到开头以便下次读通道读字节
                buffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(finChannel != null) finChannel.close();
                if(foutChannel != null) foutChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通道对数据的分散多个缓存和缓存聚集写入
     */
    @Test
    public void test2() throws IOException {
        FileChannel channel = new FileInputStream(
                "D:\\Users\\于浩强\\IdeaProjects\\JAVASTU\\src\\NIO\\test.java").getChannel();
        ByteBuffer[] byteBuffers = new ByteBuffer[8];
        for (int i = 0; i < byteBuffers.length; i++) {
            byteBuffers[i] = ByteBuffer.allocate(1024);
        }
        channel.read(byteBuffers);

        FileChannel channel1 = new FileOutputStream("T.java").getChannel();

        for (ByteBuffer b:byteBuffers){
            b.flip();
        }
        channel1.write(byteBuffers);
        channel1.close();
    }
    @Test
    public void test3(){
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        Set<String> strings = stringCharsetSortedMap.keySet();
        for (String string:strings){
            System.out.println(string);
        }
    }
}
