package com.losador.gui;

import com.losador.listeners.BackButtonListener;
import com.losador.listeners.SubmitButtonListener;

import javax.swing.*;
import java.awt.*;

public class RegistrationWindow {
    private JFrame frame;
    private JTextField login;
    private JTextField pass;
    private JTextField email;
    private Font BigFontTR = new Font("TimesRoman", Font.PLAIN, 20);
    private JButton submitButton, backButton;

    public RegistrationWindow(MainWindow window) {
        frame = new JFrame();
        frame.setSize(800, 600);
        login = new JTextField();
        login.setFont(BigFontTR);
        login.setBounds(frame.getWidth()/2 - 100, frame.getHeight()/2 - 120, 200, 40);
        frame.add(login);
        pass = new JTextField();
        pass.setFont(BigFontTR);
        pass.setBounds(frame.getWidth()/2 - 100, frame.getHeight()/2 - 60, 200, 40);
        frame.add(pass);
        email = new JTextField();
        email.setFont(BigFontTR);
        email.setBounds(frame.getWidth()/2 - 100, frame.getHeight()/2, 200, 40);
        frame.add(email);
        JTextArea loginArea = new JTextArea("Username: ");
        loginArea.setFont(BigFontTR);
        loginArea.setBackground(null);
        loginArea.setBounds(frame.getWidth()/2 - 210, frame.getHeight()/2 - 120, 100, 30);
        frame.add(loginArea);
        JTextArea passArea = new JTextArea("Password: ");
        passArea.setFont(BigFontTR);
        passArea.setBackground(null);
        passArea.setBounds(frame.getWidth()/2 - 210, frame.getHeight()/2 - 60, 100, 30);
        frame.add(passArea);
        JTextArea emailArea = new JTextArea("Email: ");
        emailArea.setFont(BigFontTR);
        emailArea.setBackground(null);
        emailArea.setBounds(frame.getWidth()/2 - 210, frame.getHeight()/2, 100, 30);
        frame.add(emailArea);
        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(frame.getWidth()/2 - 110, frame.getHeight()/2 + 70, 100, 30);
        submitButton.addActionListener(new SubmitButtonListener(this, window));
        frame.add(submitButton);
        backButton = new JButton("BACK");
        backButton.setBounds(frame.getHeight()/2 + 110, frame.getHeight()/2 + 70, 100, 30);
        backButton.addActionListener(new BackButtonListener(window, this));
        frame.add(backButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public JTextField getLogin() {
        return login;
    }

    public JTextField getPass() {
        return pass;
    }

    public JTextField getEmail() {
        return email;
    }

    public JFrame getFrame(){
        return frame;
    }

    public void hideWindow(){
        frame.setVisible(false);
    }

}
