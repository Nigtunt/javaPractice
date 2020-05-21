package Network.TcpPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TestClient extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JTextField portField;
    private JTextField hostField;

    /**
     * Launch the application
     *
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestClient frame = new TestClient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame
     */
    public TestClient() {
        super();
        setBounds(100, 100, 500, 212);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        getContentPane().add(panel, BorderLayout.NORTH);

        final JLabel label = new JLabel();
        label.setText("连接主机：");
        panel.add(label);

        hostField = new JTextField();
        hostField.setText("localhost");
        panel.add(hostField);

        final JLabel label_1 = new JLabel();
        label_1.setText("端口：");
        panel.add(label_1);

        portField = new JTextField();
        portField.setText("8001");
        panel.add(portField);

        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                final String hostName = hostField.getText();
                String portNum = portField.getText();
                final int port = Integer.parseInt(portNum);
                new Thread(() -> {
                    try {
                        final InetAddress host = InetAddress.getByName(hostName);
                        Socket socket = new Socket(host, port);
                        final InputStream is = socket.getInputStream();
                        InputStreamReader reader=new InputStreamReader(is);
                        OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                        socket.getOutputStream().write("widnhwuiadhiawuhdiuawhduiaw".getBytes());
                        int data = 0;
                        while ((data=reader.read()) != -1) {
                            textArea.append((char)data+"");
                            textArea.revalidate();
                            Thread.sleep(10);
                        }

                    } catch (Exception e1) {
                        textArea.append(e1.toString());
                        e1.printStackTrace();
                    }
                }).start();

            }
        });
        button.setText("连接");
        panel.add(button);

        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        scrollPane.setViewportView(textArea);
    }
}
