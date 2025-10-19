package project.vetsys.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitPanel{
    private JPanel main;
    private JLabel InitPanel_lblTitleWelcome;
    private JButton InitPanel_BttnEnter;
    private JLabel InitPanel_Icon;

    public InitPanel(){

        this.InitPanel_BttnEnter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("hello");
            }
        });
    }
}
