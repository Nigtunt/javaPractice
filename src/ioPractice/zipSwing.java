package ioPractice;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class zipSwing extends JFrame {
    private JTextArea jTextArea;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel;
    private JFileChooser jFileChooser;
    public zipSwing(){
        super();
        setTitle("解压/压缩");
        setLayout(null);
        jButton1=new JButton("解压");
        jButton2=new JButton("压缩");
        jFileChooser=new JFileChooser();
        jButton1.addActionListener(new action());
        jButton2.addActionListener(new action());
        jPanel=new JPanel();
        jTextArea=new JTextArea();
        jPanel.setBounds(20,20,200,50);
        jTextArea.setBounds(20,70,200,100);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        getContentPane().add(jTextArea);
        getContentPane().add(jPanel);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String args[]){
        new zipSwing();
    }

    class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==jButton1){
                Zipio zipio=new Zipio();
                jFileChooser.setDialogTitle("open file");
                int flag = 0;
                File file;
                try {
                    flag=jFileChooser.showOpenDialog(zipSwing.this);
                } catch (HeadlessException e1) {
                    e1.printStackTrace();
                }
                if(flag==JFileChooser.APPROVE_OPTION){
                    file=jFileChooser.getSelectedFile();
                    if(jTextArea.getText().equals("")){
                        jTextArea.setText("未输入目录名");
                        return;
                    }else
                    zipio.unZip(jTextArea.getText(),file);
                    jTextArea.setText("已解压到"+jTextArea.getText());
                }
            }
            if(e.getSource()==jButton2){
                if(jTextArea.getText().equals("")){
                    jTextArea.setText("未输入目录名");
                    return;
                }
                Zipio zipio=new Zipio();
                jFileChooser.setDialogTitle("open file");
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int flag = 0;
                try {
                    flag=jFileChooser.showOpenDialog(zipSwing.this);
                } catch (HeadlessException e1) {
                    e1.printStackTrace();
                }
                File file;
                if(flag==JFileChooser.APPROVE_OPTION){
                    file=jFileChooser.getSelectedFile();
                    try {
                        zipio.zip(jTextArea.getText()+file.getName()+".zip"
                                    ,file);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                }
//               zipio.zip();
            }
        }
    }
}
