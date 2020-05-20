package observer;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Subject extends JComponent {
    ArrayList<IObserver> observers = new ArrayList<>();

    public abstract void attach(IObserver observer);
    public abstract void detach(IObserver observer);
    public abstract void notifySubject();
}
