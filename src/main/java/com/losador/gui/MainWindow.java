package com.losador.gui;

import com.losador.listeners.LoginButtonListener;
import com.losador.listeners.RegisterButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    private JFrame frame;
    private JTextField login;
    private JPasswordField pass;
    private Font BigFontTR = new Font("TimesRoman", Font.PLAIN, 20);
    private JButton loginButton, registerButton;


    public MainWindow(){
        frame = new JFrame();
        frame.setSize(800, 600);
        login = new JTextField();
        login.setFont(BigFontTR);
        login.setBounds(frame.getWidth()/2 - 100, frame.getHeight()/2 - 80, 200, 40);
        frame.add(login);
        pass = new JPasswordField();
        pass.setFont(BigFontTR);
        pass.setBounds(frame.getWidth()/2 - 100, frame.getHeight()/2 - 20, 200, 40);
        frame.add(pass);
        JTextArea loginArea = new JTextArea("Username: ");
        loginArea.setFont(BigFontTR);
        loginArea.setBackground(null);
        loginArea.setBounds(frame.getWidth()/2 - 210, frame.getHeight()/2 - 80, 100, 30);
        frame.add(loginArea);
        JTextArea passArea = new JTextArea("Password:");
        passArea.setFont(BigFontTR);
        passArea.setBackground(null);
        passArea.setBounds(frame.getWidth()/2 - 210, frame.getHeight()/2 - 20, 100, 30);
        frame.add(passArea);
        loginButton = new JButton("LOG IN");
        loginButton.setBounds(frame.getWidth()/2 - 120, frame.getHeight() - frame.getHeight()/3 - 50, 110, 30);
        loginButton.addActionListener(new LoginButtonListener(login, pass, this));
        frame.add(loginButton);
        registerButton = new JButton("SIGN UP");
        registerButton.setBounds(frame.getWidth()/2 + 5, frame.getHeight() - frame.getHeight()/3 - 50, 110, 30);
        registerButton.addActionListener(new RegisterButtonListener(this));
        frame.add(registerButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void hideWindow(){
        frame.setVisible(false);
    }

    public void clearWindow(){
        login.setText("");
        pass.setText("");
    }

    public void showWindow(){
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getLogin() {
        return login;
    }

    public JPasswordField getPass() {
        return pass;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

}
