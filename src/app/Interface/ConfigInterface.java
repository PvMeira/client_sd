package app.Interface;

import app.Utils.MessageUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pvmeira on 24/06/17.
 */
public class ConfigInterface extends JFrame {
    JTextField portField;
    JLabel portLabel;
    JLabel IpLabel;
    JTextField Ipfield;
    JFrame frame;
    JButton btnLogin;

    public ConfigInterface(JTextField portField, JLabel portLabel, JLabel ipLabel, JTextField ipfield, JFrame frame) {
        this.portField = portField;
        this.portLabel = portLabel;
        IpLabel = ipLabel;
        Ipfield = ipfield;
        this.frame = frame;
    }

    public ConfigInterface() {
        frame = new JFrame();
        portLabel = new JLabel("IP : ");
        frame.add(portLabel);

        portField = new JTextField(10);
        frame.add(portField);

        IpLabel = new JLabel("Port : ");
        frame.add(IpLabel);

        Ipfield = new JTextField(10);
        frame.add(Ipfield);

        btnLogin = new JButton("Go to Login");
    }

    public void startUpConfig() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.setVisible(true);

        btnLogin.addActionListener(e -> {
            try {
//                ServerController sc = new ServerController(portField.getText(), Integer.valueOf(Ipfield.getText()));
//                sc.configClientNetWork();
                LoginInterface loginDlg = new LoginInterface(frame);
                loginDlg.setVisible(true);
                this.frame.setVisible(false);
                if (loginDlg.isSucceeded()) {
                    ClientInterface c = new ClientInterface();
                    this.frame.setVisible(false);
                    c.setVisible(true);
                }
            } catch (Exception e1) {
                MessageUtil.errorMessage(frame, "Erro de conexão", "Erro ao conectar ao servidor");
                e1.printStackTrace();
            }
        });
    }
}
