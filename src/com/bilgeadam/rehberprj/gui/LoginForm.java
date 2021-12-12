package com.bilgeadam.rehberprj.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                JOptionPane.showMessageDialog(null, "Butona Basıldı");
            }
        });
    }
}