package template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Draw extends JComponent {
    private Image image;
    private Graphics2D g2;

    private ArrayList<Figure> arrayList = new ArrayList<>();

    public Draw() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("x:" + e.getX() + " y:" + e.getY());
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();

            new Thread(() -> {
                try {
                    while (true) {
                        Thread.sleep(5);
                        clear();
                        try {
                            for (Figure o : arrayList) {
                                o.draw();
                            }
                        } catch (Exception e) {

                        }
                        repaint();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        g.drawImage(image, 0, 0, null);
    }


    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        //repaint();
    }


    public void addKvadrat() {
        arrayList.add(new Kvadrat(g2));
    }

    public void addKrug() {
        arrayList.add(new Ball(g2));
    }

    public void addStar() {
        arrayList.add(new Star(g2));
    }
}