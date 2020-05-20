package observer;

public class EyeLeftSubject extends Subject {
    private boolean isOpenedLeftEye;

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
        return isOpenedLeftEye;
    }

    public void setState(boolean states){
        isOpenedLeftEye = states;
    }
}
