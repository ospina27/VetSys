package project.vetsys.view;

import project.vetsys.utils.AccessPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitPanel implements AccessPanel {
    private JPanel InitPanelMain;
    private JLabel InitPanel_lblTitleWelcome;
    private JButton InitPanel_BttnEnter;

    public InitPanel(){

        this.InitPanel_BttnEnter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AccessPanel.changeContent("Login");
            }
        });
    }

    public JPanel getPanel(){return InitPanelMain;}
}
