package form;

import javax.swing.*;

public class Dashboard extends JFrame {

    JButton btnMustahik;
    JButton btnBantuan;
    JButton btnPenyaluran;

    public Dashboard() {

        setTitle("DASHBOARD SIMBA");
        setSize(500,300);
        setLayout(null);

        btnMustahik = new JButton("DATA MUSTAHIK");
        btnBantuan = new JButton("DATA BANTUAN");
        btnPenyaluran = new JButton("PENYALURAN");

        btnMustahik.setBounds(50,50,180,40);
        btnBantuan.setBounds(250,50,180,40);
        btnPenyaluran.setBounds(150,120,180,40);

        add(btnMustahik);
        add(btnBantuan);
        add(btnPenyaluran);

        btnMustahik.addActionListener(e -> {

            new FormMustahik();

        });

        btnBantuan.addActionListener(e -> {

            new FormBantuan();

        });

        btnPenyaluran.addActionListener(e -> {

            new FormPenyaluran();

        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}