package iterator;

import cor.ChainOfResponsibility;
import cor.Column;
import factory_method.Auto;
import factory_method.Vehicle;
import factory_method.exceptions.DuplicateModelNameException;

import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("Toyota", 3);
        Iterator a = auto.iterator();
        for(int i = 0; i < auto.getModelLength(); i++){
           System.out.println(a.next().toString());
        }
    }
}


