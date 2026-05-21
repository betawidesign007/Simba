package form;

import javax.swing.*;
import java.awt.event.*;
import config.Koneksi;

public class Login extends JFrame {

    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin;

    public Login() {

        setTitle("LOGIN SIMBA");
        setSize(350,250);
        setLayout(null);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");

        txtUser = new JTextField();
        txtPass = new JPasswordField();

        btnLogin = new JButton("LOGIN");

        l1.setBounds(30,40,100,30);
        l2.setBounds(30,80,100,30);

        txtUser.setBounds(120,40,150,30);
        txtPass.setBounds(120,80,150,30);

        btnLogin.setBounds(120,130,100,35);

        add(l1);
        add(l2);
        add(txtUser);
        add(txtPass);
        add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                login();

            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void login() {

        String user = txtUser.getText();
        String pass = txtPass.getText();

        if(user.equals("admin") && pass.equals("admin")) {

            JOptionPane.showMessageDialog(null,
                    "Login Berhasil");

            new Dashboard();

            dispose();

        } else {

            JOptionPane.showMessageDialog(null,
                    "Username / Password Salah");

        }
    }
}