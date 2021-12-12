package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.dto.KullaniciDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JTextField adTF;
    private JPasswordField sifrePF;
    private JButton girisButton;
    private JPanel jpanel1;

    public LoginForm() {

        add(jpanel1);

        // Açılan pencerede çarpıya basınca kapanmasını(programdan çıkmasını) sağlamak için.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Giriş Ekranı");

        setSize(300, 200);

        // Ekrana göre ortala
        // Mutlaka setSize dan sonra kullanılması gerekiyor
        setLocationRelativeTo(null);

        girisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Butona Basıldı");

                if (adTF.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Kullanıcı Adı alanı doldurulmalıdır.");
                    // Kullanıcı adı alanında hata var ise kşagıdaki kodları çalıştırmasın diye return ekledik.
                    return;
                }

                if (String.valueOf(sifrePF.getPassword()).length() == 0) {
                    JOptionPane.showMessageDialog(null, "Şifre alanı doldurulmalıdır.");
                    return;
                }

                try {
                    KullaniciDTO kullanici = new KullaniciDTO();
                    kullanici.setKullaniciAdi(adTF.getText());
                    kullanici.setSifre(String.valueOf(sifrePF.getPassword()));

                    boolean sonuc = KullaniciDAO.giriseYetkilimi(kullanici);

                    if (sonuc)
                        JOptionPane.showMessageDialog(null, "Girişe Yetkilidir.");
                    else
                        JOptionPane.showMessageDialog(null, "Girişe Yetkili DEĞİLDİR!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
                }
            }
        });
    }
}