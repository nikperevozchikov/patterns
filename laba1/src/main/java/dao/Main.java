package dao;

import adapter.Adapter;
import decorator.NewVehicle;
import factory_method.*;
import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.NoSuchModelNameException;
import singleton.Singleton;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException, IOException {
        Auto auto = new Auto("Toyota", 3);
        IAutoDAO view = new TextView();
        //TextView textView = new TextView();
        view.write(auto);
        Auto auto2 = view.read();
        System.out.println(auto2.toString());

        IAutoDAO view1 = new ByteView();
        //ByteView byteView = new ByteView();
        view1.write(auto);
        Auto auto1 = view1.read();
        System.out.println(auto1.toString());

    }
}
