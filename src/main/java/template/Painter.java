package template;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painter {

    JButton closeBtn,  startBtn;
    Draw draw;
    JComboBox jComboBox;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == closeBtn) {
                System.exit(0);
            } else if (e.getSource() == startBtn) {
                int k = jComboBox.getSelectedIndex();
                if(k==0) draw.addKrug();
                if(k==1) draw.addKvadrat();
                if(k==2) draw.addStar();
            }
        }
    };

    public static void main(String[] args) {
        new Painter().show();
    }

    public void show() {
        // create main frame
        JFrame frame = new JFrame("Paint");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // create draw area
        draw = new Draw();

        // add to content pane
        content.add(draw, BorderLayout.CENTER);

        // create controls to apply colors and call clear feature
        JPanel controls = new JPanel();

        startBtn = new JButton("Пуск");
        startBtn.addActionListener(actionListener);
        closeBtn = new JButton("Закрыть");
        closeBtn.addActionListener(actionListener);

        // add to panel
        controls.add(closeBtn);
        controls.add(startBtn);

        // add to content pane
        content.add(controls, BorderLayout.PAGE_END);
        jComboBox= new JComboBox();
        jComboBox.addItem("Мяч");
        jComboBox.addItem("Квадрат");
        jComboBox.addItem("Звезда");
        jComboBox.setSelectedIndex(0);;
        controls.add(jComboBox,BorderLayout.AFTER_LAST_LINE);
        frame.setSize(600, 400);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show the swing paint result
        frame.setVisible(true);
        frame.setResizable(false);
    }
}