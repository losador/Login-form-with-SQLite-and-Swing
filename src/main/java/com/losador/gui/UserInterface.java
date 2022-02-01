package com.losador.gui;

import com.losador.listeners.LogoutButtonListener;

import javax.swing.*;

public class UserInterface {

    private JFrame frame;
    private JButton logoutButton;

    public UserInterface(MainWindow window, String login){
        frame = new JFrame(login);
        frame.setSize(800, 600);
        logoutButton = new JButton("LOG OUT");
        logoutButton.setBounds(frame.getWidth()/2 - 50, frame.getHeight() - frame.getHeight()/3 - 50, 100, 50);
        logoutButton.addActionListener(new LogoutButtonListener(window, this));
        frame.add(logoutButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void hideInterface(){
        frame.setVisible(false);
    }
}
