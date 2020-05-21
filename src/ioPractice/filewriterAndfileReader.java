package ioPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class filewriterAndfileReader {
    public filewriterAndfileReader(){
        JFrame jf=new JFrame("WriterReader");
        JPanel jp=new JPanel();
        JTextArea JTA=new JTextArea();
        JButton jb1=new JButton("写入文件");
        JButton jb2=new JButton("读出文件");
        jf.setLayout(new BorderLayout());
        Container c=jf.getContentPane();
        JTA.setSize(200,200);
        jb1.setSize(70,20);
        jb2.setSize(70,20);
        jf.setSize(250,250);
        jp.add(jb1);
        jp.add(jb2);
        jb1.addActionListener(e -> {
            File f=new File("d:\\word.txt");
            if(!f.exists()) {
                try{
                    f.createNewFile();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                FileWriter FW = new FileWriter(f);
                String str=JTA.getText();
                FW.write(str);
                JTA.setText("写入成功");
                FW.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f=new File("d:\\word.txt");
                if(!f.exists()) {
                    try{
                        f.createNewFile();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if(f.length()!=0)
                    try{
                        FileReader FR=new FileReader(f);

                        char a[]=new char[1024];
                        int len=FR.read(a);
                        JTA.setText(new String(a,0,len));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
            }
        });
        c.add(jp,BorderLayout.SOUTH);
        c.add(JTA,BorderLayout.CENTER);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new filewriterAndfileReader();
    }
}