package com.losador.listeners;

import com.losador.gui.MainWindow;
import com.losador.gui.UserInterface;
import com.losador.sql.SQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogoutButtonListener implements ActionListener {

    private MainWindow window;
    private UserInterface inter;

    public LogoutButtonListener(MainWindow mainWindow, UserInterface userInterface){
        window = mainWindow;
        inter = userInterface;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inter.hideInterface();
        window.showWindow();
    }

}
