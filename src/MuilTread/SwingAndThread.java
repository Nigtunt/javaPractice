package MuilTread;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwingAndThread extends JFrame {
    private JLabel jl=new JLabel();
    private static Thread t;
    private int count=0;
    private Container container=getContentPane();
    public SwingAndThread(){
        setBounds(300,200,250,100);
        container.setLayout(null);
        URL url=SwingAndThread.class.getResource("/1.gif");
        Icon icon = new ImageIcon(url); // 实例化一个Icon
        jl.setIcon(icon); // 将图标放置在标签中
        // 设置图片在标签的最左方
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10, 10, 200, 50); // 设置标签的位置与大小
        jl.setOpaque(true);
        // 定义匿名内部类，该类实现Runnable接口
        t = new Thread(() -> { // 重写run()方法
            while (count <= 200) { // 设置循环条件
                // 将标签的横坐标用变量表示
                jl.setBounds(count, 10, 200, 50);
                try {
                    Thread.sleep(20); // 使线程休眠1000毫秒
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count += 1; // 使横坐标每次增加4
                if (count == 200) {
                    // 当图标到达标签的最右边，使其回到标签最左边
                    count = 5;
                }
            }
        });
        t.start(); // 启动线程
        container.add(jl); // 将标签添加到容器中
        setVisible(true); // 使窗体可视
        // 设置窗体的关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String args[]){
        new SwingAndThread();
    }

}
