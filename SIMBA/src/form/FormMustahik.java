package form;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class FormMustahik extends JFrame {

    JTextField txtNik;
    JTextField txtNama;
    JTextArea txtAlamat;

    JButton btnSimpan;

    public FormMustahik() {

        setTitle("DATA MUSTAHIK");
        setSize(500,400);
        setLayout(null);

        JLabel l1 = new JLabel("NIK");
        JLabel l2 = new JLabel("Nama");
        JLabel l3 = new JLabel("Alamat");

        txtNik = new JTextField();
        txtNama = new JTextField();

        txtAlamat = new JTextArea();

        btnSimpan = new JButton("SIMPAN");

        l1.setBounds(30,30,100,30);
        l2.setBounds(30,80,100,30);
        l3.setBounds(30,130,100,30);

        txtNik.setBounds(120,30,250,30);
        txtNama.setBounds(120,80,250,30);
        txtAlamat.setBounds(120,130,250,80);

        btnSimpan.setBounds(120,240,120,35);

        add(l1);
        add(l2);
        add(l3);

        add(txtNik);
        add(txtNama);
        add(txtAlamat);

        add(btnSimpan);

        // EVENT TOMBOL SIMPAN
        btnSimpan.addActionListener(e -> simpanData());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // METHOD SIMPAN DATA
    private void simpanData() {

        try {

            Connection conn = Koneksi.getKoneksi();

            String sql = "INSERT INTO tb_mustahik "
                    + "(nik, nama, alamat) VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtNik.getText());
            pst.setString(2, txtNama.getText());
            pst.setString(3, txtAlamat.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Data Berhasil Disimpan");

            kosong();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Gagal Simpan : " + e.getMessage());

        }
    }

    // METHOD KOSONGKAN FORM
    private void kosong() {

        txtNik.setText("");
        txtNama.setText("");
        txtAlamat.setText("");

    }
}