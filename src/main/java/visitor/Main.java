package visitor;

import factory_method.Auto;
import factory_method.Motorcycle;
import factory_method.exceptions.DuplicateModelNameException;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException {
        Auto auto = new Auto("Toyota", 3);
        Motorcycle motorcycle = new Motorcycle("Yamaha", 3);

        auto.accept(new PrintVisitor());

        motorcycle.accept(new PrintVisitor());
    }
}
