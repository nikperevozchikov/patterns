package observer;

import javax.swing.*;

public class EyeRightObserver implements IObserver {
    private boolean isOpenedRightEye;

    private EyeRightSubject eyeRightSubject;

    private JComponent frame;

    @Override
    public void update() {
        isOpenedRightEye = eyeRightSubject.getState();

        frame.repaint();
    }

    public EyeRightObserver(EyeRightSubject subject, JComponent frame) {
        eyeRightSubject = subject;

        this.frame = frame;
    }
}
