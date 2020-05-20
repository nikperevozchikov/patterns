package observer;

import javax.swing.*;

public class SmileObserver implements IObserver {
    private boolean isSmile;

    private SmileSubject smileSubject;

    private JComponent frame;

    @Override
    public void update() {
        isSmile = smileSubject.getState();

        frame.repaint();
    }

    public SmileObserver(SmileSubject subject, JComponent frame) {
        smileSubject = subject;

        this.frame = frame;
    }
}
