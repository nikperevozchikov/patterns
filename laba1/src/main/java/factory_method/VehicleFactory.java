package factory_method;

import factory_method.exceptions.DuplicateModelNameException;
import factory_method.exceptions.NoSuchModelNameException;

public interface VehicleFactory {
    public Vehicle createInstance(String mark, int size) throws DuplicateModelNameException, NoSuchModelNameException;
}
