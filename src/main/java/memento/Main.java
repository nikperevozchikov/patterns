package memento;


import factory_method.Auto;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Auto auto = new Auto("Toyota",1);
        auto.createMemento();
        System.out.println(auto.getMark());
        auto.setMark("Mazda");
        System.out.println(auto.getMark());
        System.out.println(auto.getMemento().getMark());

    }
}


