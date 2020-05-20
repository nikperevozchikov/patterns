package observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {
    private class Reference<T> {
        private T referent;

        public Reference(T initialValue) {
            referent = initialValue;
        }

        public void set(T newVal) {
            referent = newVal;
        }

        public T get() {
            return referent;
        }
    }

    private class ImageComponent extends JComponent {
        private BufferedImage head;
        private BufferedImage openedEye;
        private BufferedImage closedEye;
        private BufferedImage whiteNose;
        private BufferedImage redNose;
        private BufferedImage smile;
        private BufferedImage sad;

        private EyeLeftSubject eyeLeftSubject;
        private EyeRightSubject eyeRightSubject;
        private NoseSubject noseSubject;
        private SmileSubject smileSubject;

        private ImageComponent(Reference<Integer> width, Reference<Integer> height) throws IOException {
            head = ImageIO.read(new File("images/Head.png"));
            openedEye = ImageIO.read(new File("images/Open eye.png"));
            closedEye = ImageIO.read(new File("images/Close eye.png"));
            whiteNose = ImageIO.read(new File("images/White nose.png"));
            redNose = ImageIO.read(new File("images/Red nose.png"));
            smile = ImageIO.read(new File("images/Smile.png"));
            sad = ImageIO.read(new File("images/Sad.png"));

            width.set(head.getWidth() + 20);
            height.set(head.getHeight() + 35);

            setBounds(0, 0, width.get(), height.get());

            eyeLeftSubject = new EyeLeftSubject();

            eyeLeftSubject.setBounds(100, 100, openedEye.getWidth(), openedEye.getHeight());
            eyeLeftSubject.setVisible(true);

            eyeLeftSubject.setState(true);

            eyeLeftSubject.attach(new EyeLeftObserver(eyeLeftSubject, this));

            add(eyeLeftSubject);

            eyeLeftSubject.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    eyeLeftSubject.setState(!eyeLeftSubject.getState());

                    eyeLeftSubject.notifySubject();

                    System.out.println("left");
                }
            });

            eyeRightSubject = new EyeRightSubject();

            eyeRightSubject.setBounds(270, 100, openedEye.getWidth(), openedEye.getHeight());
            eyeRightSubject.setVisible(true);

            eyeRightSubject.setState(true);

            eyeRightSubject.attach(new EyeRightObserver(eyeRightSubject, this));

            add(eyeRightSubject);

            eyeRightSubject.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    eyeRightSubject.setState(!eyeRightSubject.getState());

                    eyeRightSubject.notifySubject();

                    System.out.println("right");
                }
            });

            noseSubject = new NoseSubject();

            noseSubject.setBounds(185, 200, whiteNose.getWidth(), whiteNose.getHeight());
            noseSubject.setVisible(true);

            noseSubject.setState(true);

            noseSubject.attach(new NoseObserver(noseSubject, this));

            add(noseSubject);

            noseSubject.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    noseSubject.setState(!noseSubject.getState());

                    noseSubject.notifySubject();

                    System.out.println("nose");
                }
            });

            smileSubject = new SmileSubject();

            smileSubject.setBounds(155, 400, smile.getWidth(), smile.getHeight());
            smileSubject.setVisible(true);

            smileSubject.setState(true);

            smileSubject.attach(new SmileObserver(smileSubject, this));

            add(smileSubject);

            smileSubject.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    smileSubject.setState(!smileSubject.getState());

                    smileSubject.notifySubject();

                    System.out.println("smile");
                }
            });
        }

        public void paintComponent(Graphics g) {
            g.drawImage(head, 0, 0, null);

            boolean eyeState = eyeLeftSubject.getState();

            if (eyeState) {
                g.drawImage(openedEye, 100, 100, null);
            } else {
                g.drawImage(closedEye, 100, 100, null);
            }

            eyeState = eyeRightSubject.getState();

            if (eyeState) {
                g.drawImage(openedEye, 270, 100, null);
            } else {
                g.drawImage(closedEye, 270, 100, null);
            }

          boolean isWhiteNose = noseSubject.getState();

            if (isWhiteNose) {
                g.drawImage(whiteNose, 185, 200, null);
            } else {
                g.drawImage(redNose, 185, 200, null);
            }

            boolean isSmile = smileSubject.getState();

            if (isSmile) {
                g.drawImage(smile, 155, 400, null);
            } else {
                g.drawImage(sad, 155, 400, null);
            }
        }

        @Override
        public void update(Graphics g) {
            repaint();
        }
    }

    public Frame() throws IOException {
        super("Manchik");

        setLayout(null);

        Reference<Integer> width = new Reference<>(0);
        Reference<Integer> height = new Reference<>(0);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageComponent  component = new ImageComponent(width, height);
        add(component);

        setBounds(100, 100, width.get(), height.get());
    }
}
