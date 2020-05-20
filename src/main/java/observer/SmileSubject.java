package observer;

public class SmileSubject extends Subject {
    private boolean isSmile;

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubject() {
        for(IObserver observer : observers){
            observer.update();
        }
    }

    public boolean getState(){
        return isSmile;
    }

    public void setState(boolean states){
        isSmile = states;
    }
}
