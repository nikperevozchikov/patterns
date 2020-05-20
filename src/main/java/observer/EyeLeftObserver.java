package observer;

import javax.swing.*;

public class EyeLeftObserver implements IObserver {
    private boolean isOpenedLeftEye;

    private EyeLeftSubject eyeLeftSubject;

    private JComponent frame;

    @Override
    public void update() {
        isOpenedLeftEye = eyeLeftSubject.getState();

        frame.repaint();
    }

    public EyeLeftObserver(EyeLeftSubject subject, JComponent frame){
        eyeLeftSubject = subject;

        this.frame = frame;
    }
}
