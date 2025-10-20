package project.vetsys.utils;

import project.vetsys.view.*;
import project.vetsys.view.InitPanel;
import project.vetsys.view.MainPanel;
import project.vetsys.view.LogInPanel;

import javax.swing.JPanel;

enum PanelsMap {

    WELCOME("Welcome", new InitPanel().getPanel()),
    LOGIN("Login", new LogInPanel().getPanel());


    private final String name;
    private final JPanel panel;

    PanelsMap(String name, JPanel panel) {
        this.name = name;
        this.panel = panel;
    }

    JPanel getPanelToRender() {return panel;}

    @Override
    public String toString(){return this.name;}

}
