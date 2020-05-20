package observer;

public class EyeRightSubject extends Subject {
    private boolean isOpenedRightEye;

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
        return isOpenedRightEye;
    }

    public void setState(boolean states){
        isOpenedRightEye = states;
    }
}
