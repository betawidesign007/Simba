package form;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class FormBantuan extends JFrame {

    JTextField txtNama;
    JTextField txtJenis;
    JTextField txtJumlah;
    JTextArea txtKeterangan;

    JButton btnSimpan;

    public FormBantuan() {

        setTitle("DATA BANTUAN");
        setSize(500,450);
        setLayout(null);

        JLabel l1 = new JLabel("Nama Bantuan");
        JLabel l2 = new JLabel("Jenis Bantuan");
        JLabel l3 = new JLabel("Jumlah");
        JLabel l4 = new JLabel("Keterangan");

        txtNama = new JTextField();
        txtJenis = new JTextField();
        txtJumlah = new JTextField();

        txtKeterangan = new JTextArea();

        btnSimpan = new JButton("SIMPAN");

        l1.setBounds(30,30,120,30);
        l2.setBounds(30,80,120,30);
        l3.setBounds(30,130,120,30);
        l4.setBounds(30,180,120,30);

        txtNama.setBounds(160,30,250,30);
        txtJenis.setBounds(160,80,250,30);
        txtJumlah.setBounds(160,130,250,30);
        txtKeterangan.setBounds(160,180,250,80);

        btnSimpan.setBounds(160,290,120,35);

        add(l1);
        add(l2);
        add(l3);
        add(l4);

        add(txtNama);
        add(txtJenis);
        add(txtJumlah);
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

            String sql = "INSERT INTO tb_bantuan "
                    + "(nama_bantuan, jenis_bantuan, jumlah, keterangan) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtNama.getText());
            pst.setString(2, txtJenis.getText());
            pst.setDouble(3, Double.parseDouble(txtJumlah.getText()));
            pst.setString(4, txtKeterangan.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Data Bantuan Berhasil Disimpan");

            kosong();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Gagal Simpan : " + e.getMessage());

        }
    }

    // METHOD RESET
    private void kosong() {

        txtNama.setText("");
        txtJenis.setText("");
        txtJumlah.setText("");
        txtKeterangan.setText("");

    }
}