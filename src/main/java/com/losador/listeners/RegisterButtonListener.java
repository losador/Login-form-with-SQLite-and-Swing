package com.losador.listeners;

import com.losador.gui.MainWindow;
import com.losador.gui.RegistrationWindow;
import com.losador.gui.UserInterface;
import com.losador.sql.SQLConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterButtonListener implements ActionListener {

    private MainWindow mainWindow;
    private UserInterface inter;

    public RegisterButtonListener(MainWindow window){
        mainWindow = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SQLConnection connection = new SQLConnection();
        try {
            connection.connect();
            /*connection.getPreparedRegisterStatement().setString(1, mainWindow.getLogin().getText());
            connection.getPreparedRegisterStatement().setString(2, new String(mainWindow.getPass().getPassword()));
            connection.getPreparedRegisterStatement().executeUpdate();*/
            mainWindow.hideWindow();
            RegistrationWindow regWindow = new RegistrationWindow(mainWindow);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
}
