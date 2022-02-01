package com.losador.listeners;

import com.losador.gui.MainWindow;
import com.losador.gui.UserInterface;
import com.losador.sql.SQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginButtonListener implements ActionListener {

    private JTextField login;
    private JPasswordField pass;
    private MainWindow mainWindow;

    public LoginButtonListener(JTextField log, JPasswordField password, MainWindow window){
        login = log;
        pass = password;
        mainWindow = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SQLConnection connection = new SQLConnection();
        try {
            if(Objects.equals(login.getText(), "") || new String(pass.getPassword()).equals("")){
                JOptionPane.showMessageDialog(mainWindow.getFrame(), "You must enter username and password!");
                return;
            }
            connection.connect();
            connection.getPreparedLoginStatement().setString(1, login.getText());
            connection.getPreparedLoginStatement().setString(2, new String(pass.getPassword()));
            ResultSet res = connection.getPreparedLoginStatement().executeQuery();
            if(res.next()){
               mainWindow.hideWindow();
               UserInterface userInterface = new UserInterface(mainWindow, login.getText());
            }
            else{
                JOptionPane.showMessageDialog(pass.getRootPane(), "Wrong username or pass");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
}
