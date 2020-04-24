package main;

import adapter.Adapter;
import decorator.NewVehicle;
import factory_method.*;
import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.NoSuchModelNameException;
import singleton.Singleton;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException, IOException {
        //singleton
//    Properties properties = Singleton.getProperties();
//    System.out.println(properties);
//    String str= Singleton.getProperty("db.login");
//    System.out.println(str);

        //factory method
        //auto

        Auto auto = new Auto("Lada", 4);

        auto.addNameModelAndPrice("granta", 1000);
        auto.addNameModelAndPrice("priora", 1500);
        auto.addNameModelAndPrice("kalina", 2000);
        auto.addNameModelAndPrice("niva", 2590);
        System.out.println(Vehicles.AllModels(auto));
        System.out.println(Vehicles.AllPrice(auto));
        // auto.deleteModel("nety");
        auto.deleteModel("kalina");
        //auto.setModelName("granta","priora");
        System.out.println(Vehicles.AllModels(auto));
        System.out.println(Vehicles.AllPrice(auto));
        auto.addNameModelAndPrice("kalinanew", 2500);
        System.out.println(Vehicles.AllModels(auto));
        System.out.println(Vehicles.AllPrice(auto));
        //moto
        Motorcycle moto = new Motorcycle("Kawasaki", 3);
        moto.addNameModelAndPrice("first", 1000);
        moto.addNameModelAndPrice("second", 1500);
        moto.addNameModelAndPrice("third", 2000);
        System.out.println(Vehicles.AllModels(moto));
        System.out.println(Vehicles.AllPrice(moto));
        // auto.deleteModel("fourth");

        moto.deleteModel("third");
        // moto.setModelName("first","second");
        System.out.println(Vehicles.AllModels(moto));
        System.out.println(Vehicles.AllPrice(moto));
        moto.addNameModelAndPrice("thirdnew", 2500);
        System.out.println(Vehicles.AllModels(moto));
        System.out.println(Vehicles.AllPrice(moto));

///////////////////////////////////////////
        Vehicle veh1 = Vehicles.createInstance("Лада", 3);
        System.out.println(veh1.getClass());

        Vehicles.setVehicleFactory(new MotorcycleFactory());

        Vehicle moto2 = Vehicles.createInstance("Кавасаки", 4);
        System.out.println(moto2.getClass());
        System.out.println(Vehicles.AllModels(moto2));

        System.out.println("----------a");
        Vehicle veh3 = (Auto) veh1.clone();
        System.out.println(Vehicles.AllModels(veh3));
        System.out.println(Vehicles.AllPrice(veh3));
        veh3.setPriceByName("модель авто0", 33333);
        System.out.println(Vehicles.AllPrice(veh1));
        System.out.println(Vehicles.AllPrice(veh3));
        System.out.println("------------m");
        Vehicle veh4 = (Motorcycle) moto2.clone();
        System.out.println(veh4.getModelLength());
        System.out.println(Vehicles.AllModels(veh4));
        System.out.println(Vehicles.AllPrice(veh4));
        veh4.setPriceByName("модель мото0", 44444);
        System.out.println(Vehicles.AllPrice(moto2));
        System.out.println(Vehicles.AllPrice(veh4));

        /////////// adapter

        Adapter adapter = new Adapter();
        adapter.writeByte(new String[]{"first", " second", " third"});
        String[] strings = adapter.readByte();
        for (String s : strings) {
            System.out.print(s);
        }
        System.out.print("\n");


//////////decorator
        Vehicle v = new Auto("Marka", 3);
        v.addNameModelAndPrice("first", 1000);
        NewVehicle nv = Vehicles.synchronizedVehicle(v);
        System.out.println(nv.getMark());
        System.out.println(nv.getPriceByName("first"));


    }
}
