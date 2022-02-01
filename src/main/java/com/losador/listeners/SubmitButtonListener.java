package com.losador.listeners;

import com.losador.gui.MainWindow;
import com.losador.gui.RegistrationWindow;
import com.losador.sql.SQLConnection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubmitButtonListener implements ActionListener {

    private RegistrationWindow regWindow;
    private MainWindow mainWindow;

    public SubmitButtonListener(RegistrationWindow window, MainWindow mwindow){
        regWindow = window;
        mainWindow = mwindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SQLConnection connection = new SQLConnection();
        try {
            connection.connect();
            ResultSet rs = connection.getStatement().executeQuery("SELECT login FROM users WHERE login = '" + regWindow.getLogin().getText() + "';");
            if(rs.next()){
                JOptionPane.showMessageDialog(regWindow.getFrame(), "This username is already taken!");
                return;
            }
            if(!regWindow.getEmail().getText().matches(".+@.+\\..+")){
                JOptionPane.showMessageDialog(regWindow.getFrame(), "Invalid email address!");
                return;
            }
            rs = connection.getStatement().executeQuery("SELECT email FROM users WHERE email = '" + regWindow.getEmail().getText() + "';");
            if(rs.next()){
                JOptionPane.showMessageDialog(regWindow.getFrame(), "This email already exists!");
                return;
            }
            connection.getPreparedRegisterStatement().setString(1, regWindow.getLogin().getText());
            connection.getPreparedRegisterStatement().setString(2, regWindow.getPass().getText());
            connection.getPreparedRegisterStatement().setString(3, regWindow.getEmail().getText());
            connection.getPreparedRegisterStatement().executeUpdate();
            JOptionPane.showMessageDialog(regWindow.getFrame(), "Successfully registered. Continue to log in!");
            regWindow.hideWindow();
            mainWindow.showWindow();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
