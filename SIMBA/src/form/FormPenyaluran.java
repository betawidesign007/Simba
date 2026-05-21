package form;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class FormPenyaluran extends JFrame {

    JTextField txtMustahik;
    JTextField txtBantuan;
    JTextField txtTanggal;
    JTextField txtStatus;

    JTextArea txtKeterangan;

    JButton btnSimpan;

    public FormPenyaluran() {

        setTitle("PENYALURAN BANTUAN");
        setSize(550,500);
        setLayout(null);

        JLabel l1 = new JLabel("ID Mustahik");
        JLabel l2 = new JLabel("ID Bantuan");
        JLabel l3 = new JLabel("Tanggal");
        JLabel l4 = new JLabel("Status");
        JLabel l5 = new JLabel("Keterangan");

        txtMustahik = new JTextField();
        txtBantuan = new JTextField();
        txtTanggal = new JTextField();
        txtStatus = new JTextField();

        txtKeterangan = new JTextArea();

        btnSimpan = new JButton("SIMPAN");

        l1.setBounds(30,30,120,30);
        l2.setBounds(30,80,120,30);
        l3.setBounds(30,130,120,30);
        l4.setBounds(30,180,120,30);
        l5.setBounds(30,230,120,30);

        txtMustahik.setBounds(170,30,250,30);
        txtBantuan.setBounds(170,80,250,30);
        txtTanggal.setBounds(170,130,250,30);
        txtStatus.setBounds(170,180,250,30);
        txtKeterangan.setBounds(170,230,250,80);

        btnSimpan.setBounds(170,340,120,35);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);

        add(txtMustahik);
        add(txtBantuan);
        add(txtTanggal);
        add(txtStatus);
        add(txtKeterangan);

        add(btnSimpan);

        // EVENT TOMBOL
        btnSimpan.addActionListener(e -> simpanData());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // METHOD SIMPAN
    private void simpanData() {

        try {

            Connection conn = Koneksi.getKoneksi();

            String sql = "INSERT INTO tb_penyaluran "
                    + "(id_mustahik, id_bantuan, tanggal_salur, status, keterangan) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(txtMustahik.getText()));
            pst.setInt(2, Integer.parseInt(txtBantuan.getText()));
            pst.setString(3, txtTanggal.getText());
            pst.setString(4, txtStatus.getText());
            pst.setString(5, txtKeterangan.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Data Penyaluran Berhasil Disimpan");

            kosong();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Gagal Simpan : " + e.getMessage());

        }
    }

    // METHOD RESET
    private void kosong() {

        txtMustahik.setText("");
        txtBantuan.setText("");
        txtTanggal.setText("");
        txtStatus.setText("");
        txtKeterangan.setText("");

    }
}