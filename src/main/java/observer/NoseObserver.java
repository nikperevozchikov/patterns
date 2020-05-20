package observer;

import javax.swing.*;

public class NoseObserver implements IObserver {
    private boolean isWhiteNose;

    private NoseSubject noseSubject;

    private JComponent frame;

    @Override
    public void update() {
        isWhiteNose = noseSubject.getState();

        frame.repaint();
    }

    public NoseObserver(NoseSubject subject, JComponent frame) {
        noseSubject = subject;

        this.frame = frame;
    }
}
