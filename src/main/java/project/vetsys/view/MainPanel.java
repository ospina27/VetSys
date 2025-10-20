package project.vetsys.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MainPanel extends JFrame{
    private JPanel main;
    private JPanel containerPanel;
    private JPanel PanelBar;
    private JButton TitleBar_BttnClose;
    private JLabel TitleBarName;
    private Point initialClick;


    public MainPanel(){
        titleBarDragMove();
        closeBttnInit();
        this.setContentPane(this.main);
        this.setUndecorated(true);
        this.setTitle("VetSys");
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        setSize(800, 630);
        setMaximumSize(new Dimension(800, 630));
        //center window
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JPanel getMainContent() {
        return containerPanel;
    }

    private void closeBttnInit(){
        this.TitleBar_BttnClose.setText("x");
        this.TitleBar_BttnClose.addActionListener(e -> {
            //ConnectionSource.closeConnPool();
            System.exit(0);
        });
        this.TitleBar_BttnClose.setContentAreaFilled(false);
        this.TitleBar_BttnClose.setBorderPainted(false);
        this.TitleBar_BttnClose.setFocusPainted(false);
        this.TitleBar_BttnClose.setOpaque(true);

    }

    private void titleBarDragMove() {

        this.PanelBar.addMouseListener(new MouseAdapter() {


            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                initialClick = null;
            }
        });

        this.PanelBar.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point actual = e.getLocationOnScreen();
                setLocation(actual.x - initialClick.x, actual.y - initialClick.y);
            }
        });
    }

}
