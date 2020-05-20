package observer;

public class NoseSubject extends Subject {
    private boolean isWhiteNose;

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
        return isWhiteNose;
    }

    public void setState(boolean states){
        isWhiteNose = states;
    }
}
