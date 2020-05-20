package decorator;

import factory_method.Vehicle;
import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.NoSuchModelNameException;

public class NewVehicle  {
    private Vehicle vehicle ;

    public NewVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public synchronized String[] getAllModelNames(){
        return vehicle.getAllModelNames();
    }

    public synchronized double[] getAllModelPrices(){
        return vehicle.getAllModelPrices();
    }
    public synchronized void setModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
     vehicle.setModelName(oldName,newName);
    }

    public synchronized double getPriceByName(String name) throws NoSuchModelNameException {
        return vehicle.getPriceByName(name);
    }

    public synchronized void setPriceByName (String name, double price) throws NoSuchModelNameException, DuplicateModelNameException {
        vehicle.setPriceByName(name,price);
    }

    public synchronized void addNameModelAndPrice(String name, double price) throws DuplicateModelNameException, NoSuchModelNameException{
        vehicle.addNameModelAndPrice(name,price);
    }

    public synchronized void deleteModel(String name) throws NoSuchModelNameException{
        vehicle.deleteModel(name);
    }

    public synchronized int getModelLength(){
        return  vehicle.getModelLength();
    }

    public synchronized String getMark(){
        return vehicle.getMark();
    }

    public synchronized void setMark(String mark){
        vehicle.setMark(mark);
    }

}
