package com.losador.listeners;

import com.losador.gui.MainWindow;
import com.losador.gui.RegistrationWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener {

    private MainWindow mainWindow;
    private RegistrationWindow regWindow;

    public BackButtonListener(MainWindow mainWindow, RegistrationWindow regWindow) {
        this.mainWindow = mainWindow;
        this.regWindow = regWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        regWindow.hideWindow();
        mainWindow.showWindow();
    }
}
