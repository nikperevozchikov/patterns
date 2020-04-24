package factory_method;

import factory_method.exceptions.DuplicateModelNameException;

public class MotorcycleFactory implements VehicleFactory {

    @Override
    public Motorcycle createInstance(String mark, int size) throws DuplicateModelNameException {
        return new Motorcycle(mark, size);
    }
}
