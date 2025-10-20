package project.vetsys.view.manager;

import project.vetsys.utils.AccessPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuManagerPanel implements AccessPanel{
    private JPanel MenuManagerPanelMain;
    private JLabel MenuManager_lblTitle;
    private JButton MenuManager_BttnOption1;
    private JButton MenuManager_BttnLogOut;
    private JButton MenuManager_BttnOption2;

    public MenuManagerPanel() {
        this.MenuManager_BttnOption1.addActionListener(e -> AccessPanel.changeContent("Welcome"));
        this.MenuManager_BttnOption2.addActionListener(e -> AccessPanel.changeContent("Welcome"));
        this.MenuManager_BttnLogOut.addActionListener(e -> AccessPanel.changeContent("Login"));
    }


    @Override
    public JPanel getPanel() {
        return MenuManagerPanelMain;
    }
}
