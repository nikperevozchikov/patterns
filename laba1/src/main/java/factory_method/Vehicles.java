package factory_method;

import decorator.NewVehicle;
import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.NoSuchModelNameException;

public class Vehicles {
    private static VehicleFactory factory = new AutoFactory();

    public static void setVehicleFactory(VehicleFactory factory) {
        Vehicles.factory = factory;
    }

    public static NewVehicle synchronizedVehicle (Vehicle vehicle){
        return new NewVehicle(vehicle);
    }

    public static Vehicle createInstance(String name, int size) throws DuplicateModelNameException, NoSuchModelNameException {
        return factory.createInstance(name, size);
    }

    public static double avgModels(Vehicle vehicle) {
        double avg = 0;
        double len = vehicle.getModelLength();
        double[] allDouble = vehicle.getAllModelPrices();
        for (int i = 0; i < len; i++) {
            avg += allDouble[i];
        }
        return avg / len;
    }


    public static String AllModels(Vehicle vehicle) {
        String str = "";
        String[] strings = vehicle.getAllModelNames();
        for (int i = 0; i < vehicle.getModelLength(); i++) {
            str += strings[i].concat("");
        }
        return str;
    }

    public static String AllPrice(Vehicle vehicle) {
        String str = "";
        double[] price = vehicle.getAllModelPrices();
        for (int i = 0; i < vehicle.getModelLength(); i++) {
            str += price[i] + " ";
        }
        return str;
    }


}
